package inventorycleaning.model;
import java.time.LocalDate;

public class Issuance {
    private int id;
    private int materialId;
    private int cleanerId;
    private int quantity;
    private LocalDate dateIssued;

    public Issuance(int id, int materialId, int cleanerId, int quantity, LocalDate dateIssued) {
        this.id = id;
        this.materialId = materialId;
        this.cleanerId = cleanerId;
        this.quantity = quantity;
        this.dateIssued = dateIssued;
    }

    public int getId() { return id; }
    public int getMaterialId() { return materialId; }
    public int getCleanerId() { return cleanerId; }
    public int getQuantity() { return quantity; }
    public LocalDate getDateIssued() { return dateIssued; }
}
