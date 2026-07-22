/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorycleaning;

//FIXME TEMP SOLUTION FOR DB DURING BRANCH DEV
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kaspe
 */
public class DBConnection {

    private static final String URL = "jdbc:derby:cleaninginventory;create=true";
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String USER = "test";
    private static final String PASSWORD = "test";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Derby driver not found on classpath", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void createTables() throws SQLException {
        try {
            String sql = """
                         CREATE TABLE suppliers (
                         supplier_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         contact_number VARCHAR(10),
                         email VARCHAR(100)
                         )
                         """;
            
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            System.out.println("Table created!");
        }
        catch (Error e) {
            e.printStackTrace();
        }
    }
}
