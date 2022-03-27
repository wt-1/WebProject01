package Utils;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @Description JDBC工具类
 */
public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static String path;

    /**
     * 文件的读取，只需要读取一次，就能拿到这些值
     */
    static {
        try {
            // 读取资源文件，获取到对应的值
            Properties properties = new Properties();
            // 获取src路径下的文件的唯一的方式 --> ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            // 通过文件名获取到对应的路径0
            URL resource = classLoader.getResource("datasource.properties");
            path = resource.getPath();
            // 加载文件
            properties.load(new FileReader(path));
            // 获取配置文件数据
            driver = properties.getProperty("dataSource.driver");
            url = properties.getProperty("dataSource.url");
            username = properties.getProperty("dataSource.username");
            password = properties.getProperty("dataSource.password");
            // 注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 用来获取数据库连接类 Connection
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }


    /**
     * 关闭系统资源  executeUpdate
     * @param statement
     * @param connection
     */
    public static void close(Statement sta, Connection conn) {
        if (sta != null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭系统资源
     * @param resultSet 结果集
     * @param statement 执行sql对象
     * @param connection 数据库连接对象
     */
    public static void close(ResultSet res, PreparedStatement sta, Connection conn){
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
