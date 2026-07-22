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
        
        try{
            DBConnection.createTables();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        try{
            //replace with static methods
            SupplierDAO sdao = new SupplierDAO();
            //Supplier s = new Supplier(0, "John", "Smith", "Joe@gmail.com");
            //sdao.insert(s);
            System.out.println(sdao.getAll());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}