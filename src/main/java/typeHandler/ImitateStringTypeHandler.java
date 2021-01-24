package typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 模仿StringTypeHandler
 */
public class ImitateStringTypeHandler extends BaseTypeHandler<String> {

    Logger logger = Logger.getLogger(ImitateStringTypeHandler.class);

    /**
     * 设置参数不为空的方法
     * @param preparedStatement
     * @param i 参数下标
     * @param s 参数
     * @param jdbcType 数据库类型
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        logger.info("设置string参数【"+s+"】");
        preparedStatement.setString(i,s);
    }

    /**
     * 获取结果，通过column名
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String result = resultSet.getString(s);
        logger.info("读取string参数1【"+result+"】");
        return result;
    }

    /**
     * 获取结果通过下标
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String result = resultSet.getString(i);
        logger.info("读取string参数2【"+result+"】");
        return result;
    }

    /**
     * 用于执行存储过程
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String result = callableStatement.getString(i);
        logger.info("读取string参数3【"+result+"】");
        return result;
    }
}
