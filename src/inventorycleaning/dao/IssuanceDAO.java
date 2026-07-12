package inventorycleaning.dao;
import inventorycleaning.model.Issuance;
import java.util.List;

public class IssuanceDAO {
    public List<Issuance> getAll() {
        // TODO: implement
        return null;
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
