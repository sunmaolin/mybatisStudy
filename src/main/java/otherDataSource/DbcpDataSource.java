package otherDataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 自定义DBCP数据库连接池
 */
public class DbcpDataSource implements DataSourceFactory {

    private Properties properties = null;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            //DBCP获取数据元工厂
            dataSource = BasicDataSourceFactory.createDataSource(this.properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
