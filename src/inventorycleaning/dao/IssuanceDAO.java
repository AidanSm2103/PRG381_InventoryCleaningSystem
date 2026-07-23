package inventorycleaning.dao;
import inventorycleaning.model.Issuance;
import inventorycleaning.model.Material;
import inventorycleaning.util.DBConnection;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import java.util.List;

public class IssuanceDAO {
    private final MaterialDAO materialDAO = new MaterialDAO();
    public List<Issuance> getAll() {
        List<Issuance> issuances = new ArrayList<>();

        String sql = "SELECT * FROM issuances ORDER BY date_issued DESC";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                issuances.add(new Issuance(
                        rs.getInt("id"),
                        rs.getInt("material_id"),
                        rs.getInt("cleaner_id"),
                        rs.getInt("quantity"),
                        rs.getDate("date_issued").toLocalDate()
                ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return issuances;
    }

    public List<Issuance> getRecent(int limit) {
        // TODO: implement — for Dashboard's recent issuances table, ORDER BY date DESC LIMIT ?
        List<Issuance> issuances = new ArrayList<>();

        String sql =
                "SELECT * FROM issuances ORDER BY date_issued DESC FETCH FIRST ? ROWS ONLY";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, limit);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                issuances.add(new Issuance(
                        rs.getInt("id"),
                        rs.getInt("material_id"),
                        rs.getInt("cleaner_id"),
                        rs.getInt("quantity"),
                        rs.getDate("date_issued").toLocalDate()
                ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return issuances;
    }

    public int getTodayCount() {
        // TODO: implement — count of issuances where date = today, for Dashboard stats
        String sql =
                "SELECT COUNT(*) FROM issuances WHERE date_issued = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setDate(1, Date.valueOf(LocalDate.now()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public boolean insert(Issuance issuance) {
        // TODO: implement — also responsible for triggering stock deduction via MaterialDAO
       Material material =
                materialDAO.getById(issuance.getMaterialId());

        if (material == null) {
            System.out.println("Material not found.");
            return false;
        }

        if (issuance.getQuantity() <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return false;
        }

        if (issuance.getQuantity() > material.getQuantity()) {
            System.out.println("Not enough stock available.");
            return false;
        }

        Connection con = null;

        try {

            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            String insertSql =
                    "INSERT INTO issuances(material_id, cleaner_id, quantity, date_issued) VALUES (?,?,?,?)";

            PreparedStatement insert =
                    con.prepareStatement(insertSql);

            insert.setInt(1, issuance.getMaterialId());
            insert.setInt(2, issuance.getCleanerId());
            insert.setInt(3, issuance.getQuantity());
            insert.setDate(4, Date.valueOf(issuance.getDateIssued()));

            insert.executeUpdate();

            int remainingStock =
                    material.getQuantity() - issuance.getQuantity();

            String updateSql =
                    "UPDATE materials SET quantity = ? WHERE id = ?";

            PreparedStatement update =
                    con.prepareStatement(updateSql);

            update.setInt(1, remainingStock);
            update.setInt(2, material.getId());

            update.executeUpdate();

            con.commit();

            return true;

        } catch (SQLException ex) {

            ex.printStackTrace();

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (SQLException ignored) {
            }

        } finally {

            try {

                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }

            } catch (SQLException ignored) {
            }
        }

        return false;
    }

    public List<Issuance> getByMaterial(int materialId) {
        // TODO: implement — feeds the Material Usage report
        List<Issuance> issuances = new ArrayList<>();

        String sql =
                "SELECT * FROM issuances WHERE material_id = ? ORDER BY date_issued DESC";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, materialId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                issuances.add(new Issuance(
                        rs.getInt("id"),
                        rs.getInt("material_id"),
                        rs.getInt("cleaner_id"),
                        rs.getInt("quantity"),
                        rs.getDate("date_issued").toLocalDate()
                ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return issuances;
    }

    public List<Issuance> getByCleaner(int cleanerId) {
        List<Issuance> issuances = new ArrayList<>();

        String sql =
                "SELECT * FROM issuances WHERE cleaner_id = ? ORDER BY date_issued DESC";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, cleanerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                issuances.add(new Issuance(
                        rs.getInt("id"),
                        rs.getInt("material_id"),
                        rs.getInt("cleaner_id"),
                        rs.getInt("quantity"),
                        rs.getDate("date_issued").toLocalDate()
                ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return issuances;
    }
}
