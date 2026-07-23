package inventorycleaning.dao;
import inventorycleaning.model.Issuance;
import inventorycleaning.util.DBConnection;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        return null;
    }

    public int getTodayCount() {
        // TODO: implement — count of issuances where date = today, for Dashboard stats
        return 0;
    }

    public boolean insert(Issuance issuance) {
        // TODO: implement — also responsible for triggering stock deduction via MaterialDAO
        return false;
    }

    public List<Issuance> getByMaterial(int materialId) {
        // TODO: implement — feeds the Material Usage report
        return null;
    }

    public List<Issuance> getByCleaner(int cleanerId) {
        // TODO: implement
        return null;
    }
}
