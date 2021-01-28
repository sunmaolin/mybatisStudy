package controller.cascadeTest;

import dao.cascadeMapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import pojo.cascadePojo.Employee;
import util.SqlSessionFactoryUtils;

/**
 * 级联测试
 */
public class CascadeTest {

    private static Logger logger = Logger.getLogger(CascadeTest.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            testAssociate(sqlSession);
            sqlSession.commit();
        }catch (Exception e){
            logger.info(e);
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    /**
     * 测试级联
     * @param sqlSession
     */
    public static void testAssociate(SqlSession sqlSession){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getEmployee(1);
        logger.info(employee.getRealName());
    }
}
