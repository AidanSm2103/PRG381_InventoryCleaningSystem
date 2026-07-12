package inventorycleaning;
import inventorycleaning.ui.LoginFrame;

public class Main {
    public static void main(String[] args) {
        // Opens the login page when application runs
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}