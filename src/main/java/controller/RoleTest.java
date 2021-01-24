package controller;

import dao.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import pojo.Role;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class RoleTest {

    static Logger logger = Logger.getLogger(RoleTest.class);

    public static void main(String[] args) {
//        testGetRole();
        testRoleIDUS();
    }

    public static void testGetRole(){
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.getSqlSessionFactoryByJava().openSession();

            //第一个参数为命名空间+方法确定唯一一条Sql,第二个为参数
//            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            Role role = roleMapper.getRoleByAnnotation(1);
            //如果只有一个可以简写为getRoleByXml
            Role role = sqlSession.selectOne("dao.RoleMapper.getRoleByXml",1);
            System.out.println(role);

            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            //发生异常，事务回滚
            sqlSession.rollback();
        }finally {
            //关闭资源
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    /**
     * 测试增删改查
     */
    public static void testRoleIDUS(){
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
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
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            logger.error(e);
            sqlSession.rollback();
        }finally {
            if(sqlSession == null){
                sqlSession.close();
            }
        }
    }
}
