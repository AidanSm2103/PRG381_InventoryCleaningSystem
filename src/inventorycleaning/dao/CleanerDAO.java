package inventorycleaning.dao;
import inventorycleaning.model.Cleaner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CleanerDAO {
public List<Cleaner> getAll() {
        List<Cleaner> cleanersList = new ArrayList<>();
        String sql = "SELECT * FROM ADMIN.CLEANERS";
        
        String dbUrl = "jdbc:derby://localhost:1527/cleaninginventorydb";
        String dbUser = "admin";
        String dbPassword = "admin"; 

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department"); 

                Cleaner cleaner = new Cleaner(id, name, department);
                cleanersList.add(cleaner);
            }
            
        } catch (java.sql.SQLException e) {
            System.err.println("Database error in getAll(): " + e.getMessage());
        }

        return cleanersList;
    }

public Cleaner getById(int id) {
        String sql = "SELECT * FROM ADMIN.CLEANERS WHERE id = ?";
        
        String dbUrl = "jdbc:derby://localhost:1527/cleaninginventorydb";
        String dbUser = "admin";
        String dbPassword = "admin";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Bind the ID parameter to the ? placeholder
            pstmt.setInt(1, id);
            
            // Execute the query and open the ResultSet
            try (ResultSet rs = pstmt.executeQuery()) {
                // If a matching row is found, build and return the Cleaner object
                if (rs.next()) {
                    String name = rs.getString("name");
                    String department = rs.getString("department");
                    
                    return new Cleaner(id, name, department);
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error in getById(): " + e.getMessage());
        }

        // Returns null if no record matches the ID or if an error occurs
        return null;
    }

public boolean insert(Cleaner c) {
        // The ? characters are placeholders to prevent SQL injection attacks
        String sql = "INSERT INTO ADMIN.CLEANERS (name, department) VALUES (?, ?)";
        
        String dbUrl = "jdbc:derby://localhost:1527/cleaninginventorydb";
        String dbUser = "admin";
        String dbPassword = "admin";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Grab the values from the Cleaner object passed into the method
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getDepartment());

            // executeUpdate returns the number of rows affected (should be 1 for a successful insert)
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (java.sql.SQLException e) {
            System.err.println("Database error in insert(): " + e.getMessage());
            return false;
        }
    }

public boolean update(Cleaner c) {
        String sql = "UPDATE ADMIN.CLEANERS SET name = ?, department = ? WHERE id = ?";
        
        String dbUrl = "jdbc:derby://localhost:1527/cleaninginventorydb";
        String dbUser = "admin";
        String dbPassword = "admin";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the new values for name and department
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getDepartment());
            
            // Set the ID so the database knows exactly which row to update
            pstmt.setInt(3, c.getId());

            // Execute the update and return true if a row was actually changed
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Database error in update(): " + e.getMessage());
            return false;
        }
    }

public boolean delete(int id) {
        String sql = "DELETE FROM ADMIN.CLEANERS WHERE id = ?";
        
        String dbUrl = "jdbc:derby://localhost:1527/cleaninginventorydb";
        String dbUser = "admin";
        String dbPassword = "admin";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Bind the ID parameter
            pstmt.setInt(1, id);

            // Execute the deletion and return true if a row was actually removed
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Database error in delete(): " + e.getMessage());
            return false;
        }
    }

public List<Cleaner> search(String keyword) {
        List<Cleaner> cleanersList = new ArrayList<>();
        // Search for partial matches in both name and department, ignoring case
        String sql = "SELECT * FROM ADMIN.CLEANERS WHERE LOWER(name) LIKE ? OR LOWER(department) LIKE ?";
        
        String dbUrl = "jdbc:derby://localhost:1527/cleaninginventorydb";
        String dbUser = "admin";
        String dbPassword = "admin";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Format the keyword for the LIKE operator (e.g., "%John%")
            String searchPattern = "%" + keyword.toLowerCase() + "%";
            
            // Apply the pattern to both placeholders
            pstmt.setString(1, searchPattern);
            pstmt.setString(2, searchPattern);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String department = rs.getString("department");
                    
                    cleanersList.add(new Cleaner(id, name, department));
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error in search(): " + e.getMessage());
        }

        return cleanersList;
    }
}
