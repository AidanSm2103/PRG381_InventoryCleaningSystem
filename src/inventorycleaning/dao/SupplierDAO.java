package inventorycleaning.dao;

import inventorycleaning.DBConnection;
import inventorycleaning.model.Supplier;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SupplierDAO {

    public List<Supplier> getAll() {
        // FIXME: review
        List<Supplier> suppliers = new ArrayList<>();
        String sql = String.format("""
                         SELECT * FROM suppliers
                         """);
        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                suppliers.add(new Supplier(
                        rs.getInt("supplier_id"),
                        rs.getString("name"),
                        rs.getString("contact_number"),
                        rs.getString("email")
                ));
            }

            System.out.println("All suppliers retrieved");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    public Supplier getById(int id) {
        Supplier s = null;
        String sql = """
            SELECT * FROM suppliers WHERE
            supplier_id = ? ORDER BY supplier_id
            """;
        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = new Supplier(
                        rs.getInt("supplier_id"),
                        rs.getString("name"),
                        rs.getString("contact_number"),
                        rs.getString("email")
                );
            }
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insert(Supplier s) {
        // FIXME: review
        String sql = """
                    INSERT INTO suppliers (
                    name, contact_number, email
                    ) values (
                    ?, ?, ?
                    )
                    """;
        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getContactNumber());
            ps.setString(3, s.getEmail());
            ps.executeUpdate();
            System.out.println("Supplier inserted");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Supplier s) {
        // FIXME: review
        String sql = """
                     UPDATE suppliers SET
                      name = ?, contact_number = ?, email = ?
                      WHERE supplier_id = ?
                     """;
        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getContactNumber());
            ps.setString(3, s.getEmail());
            ps.setInt(4, s.getId());
            ps.executeUpdate();
            System.out.println("Supplier updated");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        // FIXME: review
        String sql = """
                     DELETE FROM suppliers
                      WHERE supplier_id = ?
                     """;
        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Supplier deleted");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Supplier> search(String keyword) {
        // FIXME: review
        List<Supplier> suppliers = new ArrayList<Supplier>();
        String sql = """
                         SELECT * FROM suppliers
                          WHERE (name LIKE ?)
                          OR (contact_number LIKE ?)
                          OR (email LIKE ?)
                         """;
        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);) {            
            String pat = "%" + keyword + "%";
            ps.setString(1, pat);
            ps.setString(2, pat);
            ps.setString(3, pat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                suppliers.add(new Supplier(
                        rs.getInt("supplier_id"),
                        rs.getString("name"),
                        rs.getString("contact_number"),
                        rs.getString("email")
                ));
            }

            System.out.println("All suppliers retrieved");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }
}
