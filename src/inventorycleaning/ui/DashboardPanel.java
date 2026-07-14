package inventorycleaning.ui;

import inventorycleaning.dao.CleanerDAO;
import inventorycleaning.dao.IssuanceDAO;
import inventorycleaning.dao.MaterialDAO;

public class DashboardPanel extends javax.swing.JPanel {

    public DashboardPanel() {
        initComponents();
        loadDashboardData();
    }
    
    // Loading and displaying of dashboard data
    private void loadDashboardData() {
    MaterialDAO materialDAO = new MaterialDAO();
    CleanerDAO cleanerDAO = new CleanerDAO();
    IssuanceDAO issuanceDAO = new IssuanceDAO();
    
    totalMaterialsCounterLabel.setText(String.valueOf(materialDAO.getAll().size()));
    lowStockItemsCounterLabel.setText(String.valueOf(materialDAO.getLowStock().size()));
    totalCleanersCounterLabel.setText(String.valueOf(cleanerDAO.getAll().size()));
    issuancesTodayCounterLabel.setText(String.valueOf(issuanceDAO.getTodayCount()));
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        totalMaterialsLabel = new javax.swing.JLabel();
        lowStockItemsLabel = new javax.swing.JLabel();
        totalCleanersLabel = new javax.swing.JLabel();
        issuancesTodayLabel = new javax.swing.JLabel();
        totalMaterialsCounterLabel = new javax.swing.JLabel();
        lowStockItemsCounterLabel = new javax.swing.JLabel();
        totalCleanersCounterLabel = new javax.swing.JLabel();
        issuancesTodayCounterLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recentIssuancesTable = new javax.swing.JTable();
        recentIssuancesLabel = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridLayout(2, 4, 20, 5));

        totalMaterialsLabel.setBackground(new java.awt.Color(204, 255, 255));
        totalMaterialsLabel.setText("Total Materials");
        jPanel2.add(totalMaterialsLabel);

        lowStockItemsLabel.setText("Low-Stock Items");
        jPanel2.add(lowStockItemsLabel);

        totalCleanersLabel.setText("Total Cleaners");
        jPanel2.add(totalCleanersLabel);

        issuancesTodayLabel.setText("Issuances Today");
        jPanel2.add(issuancesTodayLabel);

        totalMaterialsCounterLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalMaterialsCounterLabel.setText("0");
        jPanel2.add(totalMaterialsCounterLabel);

        lowStockItemsCounterLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lowStockItemsCounterLabel.setText("0");
        jPanel2.add(lowStockItemsCounterLabel);

        totalCleanersCounterLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalCleanersCounterLabel.setText("0");
        jPanel2.add(totalCleanersCounterLabel);

        issuancesTodayCounterLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        issuancesTodayCounterLabel.setText("0");
        jPanel2.add(issuancesTodayCounterLabel);

        recentIssuancesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(recentIssuancesTable);

        recentIssuancesLabel.setText("Recent Issuances");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(recentIssuancesLabel)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(recentIssuancesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel issuancesTodayCounterLabel;
    private javax.swing.JLabel issuancesTodayLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lowStockItemsCounterLabel;
    private javax.swing.JLabel lowStockItemsLabel;
    private javax.swing.JLabel recentIssuancesLabel;
    private javax.swing.JTable recentIssuancesTable;
    private javax.swing.JLabel totalCleanersCounterLabel;
    private javax.swing.JLabel totalCleanersLabel;
    private javax.swing.JLabel totalMaterialsCounterLabel;
    private javax.swing.JLabel totalMaterialsLabel;
    // End of variables declaration//GEN-END:variables
}
