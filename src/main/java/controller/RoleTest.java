package controller;

import dao.RoleMapper;
import dao.RoleMapperTest;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import pojo.Role;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class RoleTest {

    static Logger logger = Logger.getLogger(RoleTest.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.getSqlSessionFactoryByJava().openSession();
//        testGetRole(sqlSession);
//            testRoleIDUS(sqlSession);
            testOneCache(sqlSession);
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            logger.error(e);
            sqlSession.rollback();
        } finally {
            if (sqlSession == null) {
                sqlSession.close();
            }
        }

    }

    /**
     * 测试执行sql
     * @param sqlSession
     */
    public static void testGetRole(SqlSession sqlSession) {

        //第一个参数为命名空间+方法确定唯一一条Sql,第二个为参数
//            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            Role role = roleMapper.getRoleByAnnotation(1);
        //如果只有一个可以简写为getRoleByXml
        Role role = sqlSession.selectOne("dao.RoleMapper.getRoleByXml", 1);
        System.out.println(role);

    }

    /**
     * 测试增删改查
     */
    public static void testRoleIDUS(SqlSession sqlSession) {
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            Role role = new Role();
//            role.setRoleName("张三");
//            role.setRoleSex(1);
//            int roleId = roleMapper.insertRole(role);
//            logger.error(role.getRoleId());
//            role.setNote("太太太帅了");
//            roleMapper.updateRole(role);

//            roleMapper.deleteRole(4);

        List<Role> roles = roleMapper.findRoles("张三");
        logger.info(roles);
    }

    /**
     * 测试一级缓存 以及缓存是在SqlSession上
     * 这里执行了俩次sql  查看日志可知，只执行了一次sql
     * 原因：使用了同一个sqlsession，第一次获取时将sql与参数缓存起来
     * 下次的sql与参数并没有改变  且缓存没有超时或刷新 那么就会从缓存中读取数据
     * @param sqlSession
     */
    public static void testOneCache(SqlSession sqlSession) {
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.getRoleByXml(1);
        Role role1 = roleMapper.getRoleByXml(1);
        //若是俩个不同的sqlSession呢？
        testTwoSqlSessionOneCache();
    }

    /**
     * 测试不同sqlSession是否会一级缓存  结果证明  不会
     * 那如何在不同sqlSession中共享缓存对象呢？
     * 在Mapper.xml加入<cache/> 这就是二级缓存，执行后发现  也是只执行了一遍sql
     * 二级缓存   是在SqlSessionFactory的
     */
    public static void testTwoSqlSessionOneCache(){
        SqlSession sqlSession1 = SqlSessionFactoryUtils.openSqlSession();
        SqlSession sqlSession2 = SqlSessionFactoryUtils.openSqlSession();
        RoleMapper roleMapper1 = sqlSession1.getMapper(RoleMapper.class);
        RoleMapper roleMapper2 = sqlSession2.getMapper(RoleMapper.class);
        Role role1 = roleMapper1.getRoleByXml(2);
        //一级缓存  需要提交才会进行缓存
        sqlSession1.commit();
        Role role2 = roleMapper2.getRoleByXml(2);
        sqlSession2.commit();
        sqlSession1.close();
        sqlSession2.close();
        //可以看日志发现  改sql执行了俩遍
    }


}
