package inventorycleaning.ui;

import inventorycleaning.dao.UserDAO;
import inventorycleaning.model.User;

import javax.swing.JFrame;

public class RegisterDialog extends javax.swing.JDialog {
    
    public RegisterDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Storekeeper", "Supervisor"}
        ));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newUsernameField = new javax.swing.JTextField();
        newPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        roleComboBox = new javax.swing.JComboBox<>();
        registerErrorLabel = new javax.swing.JLabel();
        submitRegisterButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        usernameRegisterLabel = new javax.swing.JLabel();
        passwordRegisterLabel = new javax.swing.JLabel();
        confirmPasswordLabel = new javax.swing.JLabel();
        roleRegisterLabel = new javax.swing.JLabel();
        registerTitleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Storekeeper", "Supervisor", " " }));

        registerErrorLabel.setForeground(new java.awt.Color(255, 51, 51));

        submitRegisterButton.setText("Submit");
        submitRegisterButton.addActionListener(this::submitRegisterButtonActionPerformed);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        usernameRegisterLabel.setText("Username");

        passwordRegisterLabel.setText("Password");

        confirmPasswordLabel.setText("Confirm Password");

        roleRegisterLabel.setText("Role");

        registerTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerTitleLabel.setText("REGISTER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitRegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(passwordRegisterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmPasswordLabel)
                        .addComponent(registerErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(confirmPasswordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(newPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(newUsernameField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usernameRegisterLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(48, 48, 48)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(roleRegisterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerTitleLabel)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameRegisterLabel)
                    .addComponent(roleRegisterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(passwordRegisterLabel)
                .addGap(2, 2, 2)
                .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmPasswordLabel)
                .addGap(5, 5, 5)
                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerErrorLabel)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitRegisterButton)
                    .addComponent(cancelButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Button for submitting registration
    private void submitRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitRegisterButtonActionPerformed
        String username = newUsernameField.getText().trim();
        String password = new String(newPasswordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        String role = (String) roleComboBox.getSelectedItem();

        // Checks for empty fields
        if (username.isEmpty() || password.isEmpty()) {
            registerErrorLabel.setText("Username and password are required");
            return;
        }

        // Checks if passwords match
        if (!password.equals(confirmPassword)) {
            registerErrorLabel.setText("Passwords do not match");
            return;
        }

        UserDAO userDAO = new UserDAO();
        // Checks for existing usernames in database
        if (userDAO.usernameExists(username)) {
            registerErrorLabel.setText("Username already taken");
            return;
        }

        // Adds user if criteria is successful
        User newUser = new User(0, username, password, role);
        boolean success = userDAO.insert(newUser);

        // Error checking for successful/failed registration
        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Registration successful. You can now log in.");
            this.dispose();
        } else {
            registerErrorLabel.setText("Registration failed, please try again");
        }
    }//GEN-LAST:event_submitRegisterButtonActionPerformed

    // Button for canceling registration
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegisterDialog dialog = new RegisterDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JTextField newUsernameField;
    private javax.swing.JLabel passwordRegisterLabel;
    private javax.swing.JLabel registerErrorLabel;
    private javax.swing.JLabel registerTitleLabel;
    private javax.swing.JComboBox<String> roleComboBox;
    private javax.swing.JLabel roleRegisterLabel;
    private javax.swing.JButton submitRegisterButton;
    private javax.swing.JLabel usernameRegisterLabel;
    // End of variables declaration//GEN-END:variables
}
