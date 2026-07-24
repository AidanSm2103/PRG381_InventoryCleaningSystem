package inventorycleaning.dao;
import inventorycleaning.model.Material;
import inventorycleaning.util.DBConnection;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class MaterialDAO {
    public List<Material> getAll() {
        List<Material> materials = new ArrayList<>();
        String sql = "SELECT * FROM materials";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                materials.add(mapRow(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materials;
    }

    public Material getById(int id) {
        Material material = null;
        String sql = "SELECT * FROM materials WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    material = mapRow(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return material;
    }

    
    public boolean insert(Material m) {
        boolean success = false;
        String sql = "INSERT INTO materials (name, quantity, reorder_level) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getName());
            stmt.setInt(2, m.getQuantity());
            stmt.setInt(3, m.getReorderLevel());
            success = stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return success;
    }   

    public boolean update(Material m) {
        boolean success = false;
        String sql = "UPDATE materials SET name = ?, quantity = ?, reorder_level = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getName());
            stmt.setInt(2, m.getQuantity());
            stmt.setInt(3, m.getReorderLevel());
            stmt.setInt(4, m.getId());
            success = stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return success;
    }

    public boolean delete(int id) {
        boolean success = false;
        String sql = "DELETE FROM materials WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            success = stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return success;
    }
    
    public List<Material> search(String keyword) {
        List<Material> materials = new ArrayList<>();
        String sql = "SELECT * FROM materials WHERE name LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    materials.add(mapRow(rs));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materials;
    }
    
    public List<Material> getLowStock() {
        List<Material> materials = new ArrayList<>();
        String sql = "SELECT * FROM materials WHERE quantity <= reorder_level";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                materials.add(mapRow(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materials;
    }
    
    private Material mapRow(ResultSet rs) throws SQLException {
        return new Material(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("quantity"),
            rs.getInt("reorder_level")
        );
    }
}
