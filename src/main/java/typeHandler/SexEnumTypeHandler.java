package typeHandler;

import myEnum.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义枚举转化类,,也可以实现TypeHandler接口
 */
public class SexEnumTypeHandler extends BaseTypeHandler<SexEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getId());
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int id = resultSet.getInt(s);
        return SexEnum.getSexById(id);
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt(i);
        return SexEnum.getSexById(id);
    }

    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int id = callableStatement.getInt(i);
        return SexEnum.getSexById(id);
    }
}
