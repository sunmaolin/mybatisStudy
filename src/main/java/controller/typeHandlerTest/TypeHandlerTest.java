package controller.typeHandlerTest;

import dao.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import pojo.Role;
import util.SqlSessionFactoryUtils;

public class TypeHandlerTest {

    private static Logger logger = Logger.getLogger(TypeHandlerTest.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
//            typeHandlerTest(sqlSession);
            enumOrdinalTypeHandlerTest(sqlSession);
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            //发生异常回滚
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    /**
     * 测试类型转换
     * @param sqlSession
     * @throws Exception
     */
    public static void typeHandlerTest(SqlSession sqlSession) throws Exception{
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        String roleName = roleMapper.getRoleName(1);
        logger.info(roleName);
    }

    /**
     * 测试mybatis自带枚举转换器enumOrdinalTypeHandler(根据下标转换)
     * 还有一种是根据EnumTypeHandler(根据名称转换),调用的是valueOf(SexEnum.class,"MALE"),差不多
     * @param sqlSession
     * @throws Exception
     */
    public static void enumOrdinalTypeHandlerTest(SqlSession sqlSession) throws Exception{
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.getSexByEnumOrdinal(1);
        logger.info(role.getSexEnum().name());
    }


}
