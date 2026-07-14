package inventorycleaning.ui;
import java.awt.CardLayout;
import inventorycleaning.util.CardNames;
import inventorycleaning.model.User;

public class MainFrame extends javax.swing.JFrame {

    // The currently authenticated user, passed in from LoginFrame
     private User loggedInUser;
     
    public MainFrame(User user) {
        this.loggedInUser = user;
        initComponents();
        
        // Card layout set up for navigation
        contentPanel.setLayout(new CardLayout());
        contentPanel.add(new DashboardPanel(), CardNames.DASHBOARD);
        contentPanel.add(new MaterialsPanel(), CardNames.MATERIALS);
        contentPanel.add(new SuppliersPanel(), CardNames.SUPPLIERS);
        contentPanel.add(new CleanersPanel(), CardNames.CLEANERS);
        contentPanel.add(new IssuancePanel(), CardNames.STOCK_ISSUANCE);
        contentPanel.add(new ReportsPanel(loggedInUser), CardNames.REPORTS);
        
        applyRolePermissions();
    }
    
    // Disables UI elements the current user's role shouldn't have access to
    private void applyRolePermissions() {
        boolean isSupervisor = "Supervisor".equals(loggedInUser.getRole());
        reportsButton.setEnabled(isSupervisor);
        reportsButton.setToolTipText(isSupervisor ? null : "Supervisor access only");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dashboardButton = new javax.swing.JButton();
        materialsButton = new javax.swing.JButton();
        suppliersButton = new javax.swing.JButton();
        cleanersButton = new javax.swing.JButton();
        issuanceButton = new javax.swing.JButton();
        reportsButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        navPanel.setBackground(new java.awt.Color(204, 204, 204));
        navPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        navPanel.setLayout(new java.awt.GridLayout(8, 1, 0, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Inventory Cleaning");
        navPanel.add(jLabel1);

        dashboardButton.setText("Dashboard");
        dashboardButton.setMinimumSize(new java.awt.Dimension(44, 10));
        dashboardButton.addActionListener(this::dashboardButtonActionPerformed);
        navPanel.add(dashboardButton);

        materialsButton.setText("Materials");
        materialsButton.addActionListener(this::materialsButtonActionPerformed);
        navPanel.add(materialsButton);

        suppliersButton.setText("Suppliers");
        suppliersButton.addActionListener(this::suppliersButtonActionPerformed);
        navPanel.add(suppliersButton);

        cleanersButton.setText("Cleaners");
        cleanersButton.addActionListener(this::cleanersButtonActionPerformed);
        navPanel.add(cleanersButton);

        issuanceButton.setText("Issuance");
        issuanceButton.addActionListener(this::issuanceButtonActionPerformed);
        navPanel.add(issuanceButton);

        reportsButton.setText("Reports");
        reportsButton.addActionListener(this::reportsButtonActionPerformed);
        navPanel.add(reportsButton);

        logoutButton.setText("Logout");
        logoutButton.addActionListener(this::logoutButtonActionPerformed);
        navPanel.add(logoutButton);

        getContentPane().add(navPanel, java.awt.BorderLayout.LINE_START);

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Nav button for dashboard screen
    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, CardNames.DASHBOARD);
    }//GEN-LAST:event_dashboardButtonActionPerformed

    // Nav button for materials screen
    private void materialsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialsButtonActionPerformed
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, CardNames.MATERIALS);
    }//GEN-LAST:event_materialsButtonActionPerformed

    // Nav button for suppliers screen
    private void suppliersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersButtonActionPerformed
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, CardNames.SUPPLIERS);
    }//GEN-LAST:event_suppliersButtonActionPerformed

    // Nav button for cleaners screen
    private void cleanersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanersButtonActionPerformed
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, CardNames.CLEANERS);
    }//GEN-LAST:event_cleanersButtonActionPerformed

    // Nav button for stock issuance screen
    private void issuanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuanceButtonActionPerformed
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, CardNames.STOCK_ISSUANCE);
    }//GEN-LAST:event_issuanceButtonActionPerformed

    // Nav button for reports screen
    private void reportsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsButtonActionPerformed
        // Checks if user is a Supervisor before granting access
        if (!"Supervisor".equals(loggedInUser.getRole())) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "You do not have permission to view this screen.");
        return;
    }
        
    CardLayout cl = (CardLayout) contentPanel.getLayout();
    cl.show(contentPanel, CardNames.REPORTS);
    }//GEN-LAST:event_reportsButtonActionPerformed

    // Button for logging out
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // Opens a confirmation dialog
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to log out?",
        "Confirm Logout",
        javax.swing.JOptionPane.YES_NO_OPTION
    );

    // Reads dialog option
    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_logoutButtonActionPerformed

    /*public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(() -> {
            User testUser = new User(0, "testuser", "test", "Supervisor");
            new MainFrame(testUser).setVisible(true);
    });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cleanersButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton issuanceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton materialsButton;
    private javax.swing.JPanel navPanel;
    private javax.swing.JButton reportsButton;
    private javax.swing.JButton suppliersButton;
    // End of variables declaration//GEN-END:variables
}
