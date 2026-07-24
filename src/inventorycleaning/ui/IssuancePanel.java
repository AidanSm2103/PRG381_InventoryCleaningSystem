package inventorycleaning.ui;
import inventorycleaning.dao.CleanerDAO;
import inventorycleaning.dao.IssuanceDAO;
import inventorycleaning.dao.MaterialDAO;

import inventorycleaning.model.Cleaner;
import inventorycleaning.model.Issuance;
import inventorycleaning.model.Material;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;


public class IssuancePanel extends javax.swing.JPanel {

    private final MaterialDAO materialDAO;
    private final CleanerDAO cleanerDAO;
    private final IssuanceDAO issuanceDAO;
    
    
    public IssuancePanel() {
        initComponents();
        
        materialDAO = new MaterialDAO();
        cleanerDAO = new CleanerDAO();
        issuanceDAO = new IssuanceDAO();

        qtySpinner.setModel(new SpinnerNumberModel(1,1,1000,1));
        
        setupTable();
        loadMaterials();
        loadCleaners();
        loadIssuanceHistory();
        
    this.addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentShown(java.awt.event.ComponentEvent evt) {
            setupTable();
            loadMaterials();
            loadIssuanceHistory();
        }
    });
    }
     
    private void setupTable(){

    DefaultTableModel model = new DefaultTableModel();

    model.addColumn("ID");
    model.addColumn("Material ID");
    model.addColumn("Cleaner ID");
    model.addColumn("Quantity");
    model.addColumn("Date");

    issuanceTable.setModel(model);
}
    
    private void loadMaterials(){
        materialBox.removeAllItems();

        List<Material> materials = materialDAO.getAll();

        for(Material row : materials){
            materialBox.addItem(row.getId() + " - " + row.getName());
        }
}
    
    private void loadCleaners(){
        cleanerBox.removeAllItems();

        List<Cleaner> cleaners = cleanerDAO.getAll();

        for(Cleaner cleaner : cleaners){
            cleanerBox.addItem(cleaner.getId() + " - " + cleaner.getName());
        }

}
    private void loadIssuanceHistory(){
    DefaultTableModel model = (DefaultTableModel) issuanceTable.getModel();
    model.setRowCount(0);
    
    List<Issuance> list = issuanceDAO.getAll();

    for(Issuance issuance : list){
        model.addRow(new Object[]{
                issuance.getId(),
                issuance.getMaterialId(),
                issuance.getCleanerId(),
                issuance.getQuantity(),
                issuance.getDateIssued()
        });
    }

}
    private int getSelectedMaterialId() {
        if (materialBox.getSelectedItem() == null) {
            return -1;
        }

    String selected = materialBox.getSelectedItem().toString();

    return Integer.parseInt(selected.split(" - ")[0]);
}
    
    private int getSelectedCleanerId() {
        if (cleanerBox.getSelectedItem() == null) {
            return -1;
        }

    String selected = cleanerBox.getSelectedItem().toString();

    return Integer.parseInt(selected.split(" - ")[0]);

}
    
    private void clearForm() {

        if (materialBox.getItemCount() > 0) {
            materialBox.setSelectedIndex(0);
        }

        if (cleanerBox.getItemCount() > 0) {
            cleanerBox.setSelectedIndex(0);
        }

    qtySpinner.setValue(1);
}
    
    private void issueStock() {
        int materialId = getSelectedMaterialId();
        int cleanerId = getSelectedCleanerId();
        int quantity = (Integer) qtySpinner.getValue();

        if (materialId == -1) {
            JOptionPane.showMessageDialog(
                this,
                "Please select a material."
            );

        return;
    }

    if (cleanerId == -1) {
        JOptionPane.showMessageDialog(
                this,
                "Please select a cleaner."
        );

        return;
    }

    if (quantity <= 0) {
        JOptionPane.showMessageDialog(
                this,
                "Quantity must be greater than zero."
        );

        return;
    }

    Issuance issuance = new Issuance(
            0,
            materialId,
            cleanerId,
            quantity,
            LocalDate.now()
    );

    boolean success =
            issuanceDAO.insert(issuance);

    if (success) {
        JOptionPane.showMessageDialog(
                this,
                "Stock issued successfully."
        );

        loadMaterials();
        loadIssuanceHistory();
        clearForm();
    }
    else {
        JOptionPane.showMessageDialog(
                this,
                "Unable to issue stock.\nCheck available quantity."
        );
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        materialBox = new javax.swing.JComboBox<>();
        cleanerBox = new javax.swing.JComboBox<>();
        qtySpinner = new javax.swing.JSpinner();
        materialLabel = new javax.swing.JLabel();
        cleanerLabel = new javax.swing.JLabel();
        qtyLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        issuanceTable = new javax.swing.JTable();
        issueButton = new javax.swing.JButton();

        materialBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cleanerBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        materialLabel.setText("Material");

        cleanerLabel.setText("Cleaner");

        qtyLabel.setText("Qty");

        issuanceTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(issuanceTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(materialLabel)
                            .addComponent(materialBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cleanerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(cleanerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qtySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtyLabel))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materialLabel)
                    .addComponent(cleanerLabel)
                    .addComponent(qtyLabel))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materialBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cleanerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        issueButton.setText("IssueStock");
        issueButton.setName("issueButton"); // NOI18N
        issueButton.addActionListener(this::issueButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(issueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 96, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 97, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(414, Short.MAX_VALUE)
                .addComponent(issueButton)
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 47, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 47, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void issueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueButtonActionPerformed
        issueStock();
    }//GEN-LAST:event_issueButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cleanerBox;
    private javax.swing.JLabel cleanerLabel;
    private javax.swing.JTable issuanceTable;
    private javax.swing.JButton issueButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> materialBox;
    private javax.swing.JLabel materialLabel;
    private javax.swing.JLabel qtyLabel;
    private javax.swing.JSpinner qtySpinner;
    // End of variables declaration//GEN-END:variables
}
