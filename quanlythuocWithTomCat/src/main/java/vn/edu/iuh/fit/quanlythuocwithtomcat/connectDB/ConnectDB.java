package vn.edu.iuh.fit.quanlythuocwithtomcat.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:mariadb://localhost:3306/chunggkdb";
    private static final String USER = "root";
    private static final String PASSWORD = "sapassword";
    static {
        try {
        Class.forName("org.mariadb.jdbc.Driver");

    }catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

}
public static Connection getConnection()throws SQLException {
        System.out.println(URL);
        return DriverManager.getConnection(URL,USER,PASSWORD);
}
}
