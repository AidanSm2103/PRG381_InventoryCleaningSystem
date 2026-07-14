package inventorycleaning.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:derby://localhost:1527/cleaninginventorydb";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
