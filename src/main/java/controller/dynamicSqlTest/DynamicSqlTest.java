package controller.dynamicSqlTest;

import dao.DynamicSqlMapperTest;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import pojo.Role;
import util.SqlSessionFactoryUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 动态Sql测试
 */
public class DynamicSqlTest {
    private static Logger logger = Logger.getLogger(DynamicSqlTest.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            DynamicSqlMapperTest dynamicSqlMapperTest = sqlSession.getMapper(DynamicSqlMapperTest.class);
            Role role = null;
//            role = dynamicSqlMapperTest.testIf("郑婷");
//            role = dynamicSqlMapperTest.testIf(null);
//            role = dynamicSqlMapperTest.testChooseWhenOtherwise(2,"郑婷");
//            role = dynamicSqlMapperTest.testChooseWhenOtherwise(0,"郑婷");
//            role = dynamicSqlMapperTest.testChooseWhenOtherwise(0,"");
//            role = dynamicSqlMapperTest.testTrim(1,"孙茂林");
//            role = dynamicSqlMapperTest.testWhere(1,"孙茂林");
//            dynamicSqlMapperTest.testSet(1,"张飞");
            List<Role> roleList = dynamicSqlMapperTest.testForeach(Arrays.asList(1,2));
            logger.info(roleList);
//            role = dynamicSqlMapperTest.testBind("茂","帅");
            logger.info(role);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            logger.error(e);
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }




}
