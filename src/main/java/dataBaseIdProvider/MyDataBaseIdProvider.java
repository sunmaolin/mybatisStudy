package dataBaseIdProvider;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 自定义数据库厂商,比如我们使用三方数据库时
 */
public class MyDataBaseIdProvider implements DatabaseIdProvider {

    private static final String DATABASE_TYPE_DB2 = "DB2";
    private static final String DATABASE_TYPE_MYSQL = "MySQL";
    private static final String DATABASE_TYPE_ORACLE = "Oracle";

    Logger logger = Logger.getLogger(MyDataBaseIdProvider.class);

    /**
     * 这个方法是根据自己匹配的数据库返回的字符串去mapper的xml中寻找databaseId相同值的语句执行
     * @param dataSource
     * @return
     * @throws SQLException
     */
    public String getDatabaseId(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        //获取数据库产品名称
        String productName = connection.getMetaData().getDatabaseProductName();
        if(MyDataBaseIdProvider.DATABASE_TYPE_DB2.equals(productName)){
            return "db2";
        }else if(MyDataBaseIdProvider.DATABASE_TYPE_MYSQL.equals(productName)){
            return "mysql";
        }else if (MyDataBaseIdProvider.DATABASE_TYPE_ORACLE.equals(productName)){
            return "oracle";
        }
        return null;
    }

    /**
     * 该方法可以读取配置的参数
     * @param p
     */
    public void setProperties(Properties p) {
        logger.info(p);
    }
}
