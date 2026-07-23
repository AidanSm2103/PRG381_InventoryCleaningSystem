package inventorycleaning;
import inventorycleaning.ui.LoginFrame;
import java.sql.SQLException;
import inventorycleaning.dao.SupplierDAO;
import inventorycleaning.model.Supplier;

public class Main {
    public static void main(String[] args) {
        // Opens the login page when application runs
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}