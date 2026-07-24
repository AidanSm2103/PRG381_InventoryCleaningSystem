/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventorycleaning.ui;
import inventorycleaning.dao.MaterialDAO;
import inventorycleaning.model.Material;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MaterialsPanel extends javax.swing.JPanel {

    public MaterialsPanel() {
        initComponents();
        loadMaterialsData();

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                loadMaterialsData();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        materialsTable = new javax.swing.JTable();
        searchMaterialsField = new javax.swing.JTextField();
        searchMaterialsButton = new javax.swing.JButton();
        addMaterialsButton = new javax.swing.JButton();
        editMaterialsButton = new javax.swing.JButton();
        deleteMaterialsButton = new javax.swing.JButton();

        materialsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(materialsTable);

        searchMaterialsButton.setText("Search");
        searchMaterialsButton.addActionListener(this::searchMaterialsButtonActionPerformed);

        addMaterialsButton.setText("Add");
        addMaterialsButton.addActionListener(this::addMaterialsButtonActionPerformed);

        editMaterialsButton.setText("Edit");
        editMaterialsButton.addActionListener(this::editMaterialsButtonActionPerformed);

        deleteMaterialsButton.setText("Delete");
        deleteMaterialsButton.addActionListener(this::deleteMaterialsButtonActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addMaterialsButton)
                        .addGap(18, 18, 18)
                        .addComponent(editMaterialsButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteMaterialsButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchMaterialsField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchMaterialsButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchMaterialsField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchMaterialsButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteMaterialsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addMaterialsButton)
                        .addComponent(editMaterialsButton))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchMaterialsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMaterialsButtonActionPerformed
        MaterialDAO dao = new MaterialDAO();

        DefaultTableModel model = (DefaultTableModel) materialsTable.getModel();
        model.setRowCount(0); // clear existing rows before showing search results

        for (Material m : dao.search(searchMaterialsField.getText())) {
            model.addRow(new Object[]{m.getId(), m.getName(), m.getQuantity(), m.getReorderLevel()});
        }
    }//GEN-LAST:event_searchMaterialsButtonActionPerformed

    private void editMaterialsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMaterialsButtonActionPerformed
        MaterialDAO dao = new MaterialDAO();

    try {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the material you want to update:"));

        Material existing = dao.getById(id);
        if (existing == null) {
            JOptionPane.showMessageDialog(this, "No material found with that ID.");
            return;
        }

        String name = JOptionPane.showInputDialog("Enter the new name:", existing.getName());
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter the new quantity:", existing.getQuantity()));
        int reorderLevel = Integer.parseInt(JOptionPane.showInputDialog("Enter the new reorder level:", existing.getReorderLevel()));

        Material updated = new Material(id, name, quantity, reorderLevel);
        boolean success = dao.update(updated);

        if (success) {
            JOptionPane.showMessageDialog(this, "Material updated successfully.");
            loadMaterialsData(); // refresh table
        } else {
            JOptionPane.showMessageDialog(this, "Update failed.");
        }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }//GEN-LAST:event_editMaterialsButtonActionPerformed

    private void deleteMaterialsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMaterialsButtonActionPerformed
        MaterialDAO dao = new MaterialDAO();

        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the material you want to delete:"));

            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this material?", "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = dao.delete(id);
            if (success) {
                JOptionPane.showMessageDialog(this, "Material deleted.");
                loadMaterialsData(); // refresh table
            } else {
                JOptionPane.showMessageDialog(this, "Delete failed — check the ID exists.");
            }
        }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID.");
        }
    }//GEN-LAST:event_deleteMaterialsButtonActionPerformed

    private void addMaterialsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMaterialsButtonActionPerformed
        MaterialDAO dao = new MaterialDAO();

        try {
            String name = JOptionPane.showInputDialog("Enter the name of the new material:");
            int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity of the new material:"));
            int reorderLevel = Integer.parseInt(JOptionPane.showInputDialog("Enter the reorder level of the new material:"));

            Material material = new Material(0, name, quantity, reorderLevel);
            boolean success = dao.insert(material);

            if (success) {
                JOptionPane.showMessageDialog(this, "Material added successfully.");
                loadMaterialsData(); // refresh table
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add material.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }//GEN-LAST:event_addMaterialsButtonActionPerformed

    private void loadMaterialsData() {
    MaterialDAO dao = new MaterialDAO();
    DefaultTableModel model = (DefaultTableModel) materialsTable.getModel();
    model.setRowCount(0);

    for (Material m : dao.getAll()) {
        model.addRow(new Object[]{m.getId(), m.getName(), m.getQuantity(), m.getReorderLevel()});
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMaterialsButton;
    private javax.swing.JButton deleteMaterialsButton;
    private javax.swing.JButton editMaterialsButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable materialsTable;
    private javax.swing.JButton searchMaterialsButton;
    private javax.swing.JTextField searchMaterialsField;
    // End of variables declaration//GEN-END:variables
}
