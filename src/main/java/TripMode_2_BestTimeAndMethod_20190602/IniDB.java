package TripMode_2_BestTimeAndMethod_20190602;

import java.sql.Connection;
import java.sql.DriverManager;

public class IniDB {
    public Connection connection;
    public IniDB()throws Exception{
        String URL = "jdbc:mysql://127.0.0.1:3306/tripmode?characterEncoding=utf8&serverTimezone=UTC";
        String USER_NAME = "tripmode";
        String PASSWORD = "123456";
        String driver = "com.mysql.cj.jdbc.Driver";
        connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("数据库连接成功");
            }
        }catch (ClassNotFoundException e){
            System.out.println("数据库驱动没有安装");
        }catch (Exception e){
            System.out.println(e);
            System.out.println("数据库连接失败");
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
