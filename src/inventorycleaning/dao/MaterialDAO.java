package inventorycleaning.dao;
import inventorycleaning.model.Material;
import inventorycleaning.util.DBConnection;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MaterialDAO {
    public List<String[]> getAll() {
        ArrayList<String[]> dataList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM materials";
            ResultSet table = con.createStatement().executeQuery(query);
            
            while(table.next()){
                String id = table.getString("id");
                String name = table.getString("name");
                String quantity = table.getString("quantity");
                String reorder_level = table.getString("reorder_level");
                
                String[] row = {id, name, quantity, reorder_level};
                dataList.add(row);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return dataList;
    }

    public Material getById(String id) {
        Material output = null;
        
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM materials WHERE id = " + id;
            ResultSet result = con.createStatement().executeQuery(query);
            
            int mID = result.getInt("id");
            String name = result.getString("name");
            int quantity = result.getInt("quantity");
            int reorder_level = result.getInt("reorder_level");
            
            output = new Material(mID, name, quantity, reorder_level);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return output;
    }

    public boolean insert(Material m) {
        boolean output = false;
        
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO materials VALUES(" + m.getId() + ", '" + m.getName() + "', " + m.getQuantity() + ", " + m.getReorderLevel() + ")";
            output = con.createStatement().execute(query);
            System.out.println("Successfully added.");
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Unable to add.");
        }
        return output;
    }

    public boolean update(String id, String choice, String update) {
        boolean output = false;
        
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE materials SET " + choice + " = " + update + " WHERE id = " + id;
            output = con.createStatement().execute(query);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return output;
    }

    public boolean delete(String id) {
        boolean output = false;
        
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM materials WHERE id = " + id;
            output = con.createStatement().execute(query);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return output;
    }
    
    public List<String[]> search(String keyword) {
        ArrayList<String[]> dataList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM materials WHERE name LIKE " + keyword;
            ResultSet table = con.createStatement().executeQuery(query);
            
            while(table.next()){
                String id = table.getString("id");
                String name = table.getString("name");
                String quantity = table.getString("quantity");
                String reorder_level = table.getString("reorder_level");
                
                String[] row = {id, name, quantity, reorder_level};
                dataList.add(row);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return dataList;
    }
    
    public List<String[]> getLowStock() {
        ArrayList<String[]> dataList = new ArrayList<>();
        
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM materials WHERE quantity <= reorder_level";
            ResultSet table = con.createStatement().executeQuery(query);
            
            while(table.next()){
                String id = table.getString("id");
                String name = table.getString("name");
                String quantity = table.getString("quantity");
                String reorder_level = table.getString("reorder_level");
                
                String[] row = {id, name, quantity, reorder_level};
                dataList.add(row);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return dataList;
    }
}
