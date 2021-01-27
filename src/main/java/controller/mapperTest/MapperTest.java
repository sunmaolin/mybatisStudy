package controller.mapperTest;

import dao.RoleMapperTest;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import pojo.Role;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class MapperTest {

    private static Logger logger = Logger.getLogger(MapperTest.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
//            testRowBounds(sqlSession);
//            testGenerateKey(sqlSession);
//            testCustomizeKey(sqlSession);
            testVariable(sqlSession);
        }catch (Exception e){
            e.printStackTrace();
            //回滚
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    /**
     * 测试mybatis自带分页查询,适用于小数据量,大数据量性能不佳
     * 因为是执行sql后才进行筛选
     * @param sqlSession
     */
    public static void testRowBounds(SqlSession sqlSession){
        RoleMapperTest roleMapperTest = sqlSession.getMapper(RoleMapperTest.class);
        //分页限制
        RowBounds rowBounds = new RowBounds(0,2);
        List<Role> roles = roleMapperTest.rowBoundsTest(rowBounds);
        logger.info(roles);
    }

    /**
     * 测试主键回填
     * @param sqlSession
     */
    public static void testGenerateKey(SqlSession sqlSession){
        RoleMapperTest roleMapperTest = sqlSession.getMapper(RoleMapperTest.class);
        Role role = new Role();
        role.setRoleName("测试主键回填");
        role.setRolePhone("15069120633");
        //返回受影响的行数
        int affectedRows = roleMapperTest.generateKeyTest(role);
        logger.info("受影响的行数:"+affectedRows);
        logger.info(role);
    }

    /**
     * 测试插入自定义主键 规则:主键最大值+3
     * @param sqlSession
     */
    public static void testCustomizeKey(SqlSession sqlSession){
        RoleMapperTest roleMapperTest = sqlSession.getMapper(RoleMapperTest.class);
        Role role = new Role();
        role.setRoleName("测试自定义主键");
        int affectedRows = roleMapperTest.customizeKeyTest(role);
        logger.info(affectedRows);
        logger.info(role);
    }

    /**
     * 测试定义变量sql
     * @param sqlSession
     */
    public static void testVariable(SqlSession sqlSession){
        RoleMapperTest roleMapperTest = sqlSession.getMapper(RoleMapperTest.class);
        Role role = roleMapperTest.variableSqlTest(1);
        logger.info(role);
    }


}
