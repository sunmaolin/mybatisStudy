package util;

import dao.RoleMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import pojo.Role;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 创建sqlsession会话工具类
 */
public class SqlSessionFactoryUtils {

    private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;

    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 私有化构造器
     */
    private SqlSessionFactoryUtils(){}

    /**
     * 通过java代码配置mybatis并生成sqlSession
     * 这里其实是多例了，应该是单例，只获取一个SqlSessionFactory，他类似连接池
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactoryByJava(){
        //数据库连接池信息
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver("com.mysql.cj.jdbc.Driver");
        pooledDataSource.setUrl("jdbc:mysql://localhost:3306/mybatisStudy?serverTimezone=Asia/Shanghai");
        pooledDataSource.setUsername("root");
        pooledDataSource.setPassword("000");
        //看字面意思是，是否总是提交
        pooledDataSource.setDefaultAutoCommit(false);
        //采用mybatis的JDBC事务管理
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        //创建环境
        Environment environment = new Environment("devolpment",transactionFactory,pooledDataSource);

        //创建配置对象
        Configuration configuration = new Configuration(environment);
        //注册一个mybatis上下文别名
        configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
        //加入一个映射器
        //1.这里需要注意，xml的路径名需要与该接口路径名一致，否则使用xml的方式执行sql扫描不到（注解可以）
        configuration.addMapper(RoleMapper.class);

        //打印下所有接口声明的名字
//        System.out.println(configuration.getMappedStatementNames().toString());

        //使用sqlSessionFactoryBuilder创建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        return sqlSessionFactory;
    }

    /**
     * 通过读取配置获取sqlSession
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactoryByConfig(){
        synchronized (LOCK){
            if(sqlSessionFactory != null){
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
                //读取jdbc的配置信息,在数据库配置加密需要解密的情况下可以使用下面的方式
                /*Properties properties = new Properties();
                inputStream = Resources.getResourceAsStream("jdbc.properties");
                properties.load(inputStream);
                String password = properties.getProperty("password");
                //TODO 进行密码解密
                properties.put("password",password);*/
                //读取配置文件
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

    /**
     * 获取会话窗口
     * @return
     */
    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null){
            sqlSessionFactory = getSqlSessionFactoryByConfig();
        }
        return sqlSessionFactory.openSession();
    }



}
