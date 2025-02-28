
package hbs;

import Config.dbConnector;
import admin.adminDashboard;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import user.userDashboard;


public class LoginForm extends javax.swing.JFrame {

  
     public LoginForm() {
        initComponents();
        this.setResizable(false);
    }
    
    static String status;
    static String type;
    
    public static boolean loginAcc(String username, String password) {
        dbConnector connector = new dbConnector();
        try {
            String query = "SELECT * FROM tbl_user WHERE u_user = '" + username + "' AND u_pass = '" + password + "'";
            ResultSet resultSet = connector.getData(query);
            
            if (resultSet.next()) {
                status = resultSet.getString("u_status");
                type = resultSet.getString("u_type");
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 430));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Main.setBackground(new java.awt.Color(255, 255, 255));
        Main.setPreferredSize(new java.awt.Dimension(800, 420));
        Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Password");
        Main.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 70, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Username");
        Main.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        user.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user.setMinimumSize(new java.awt.Dimension(8, 20));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        Main.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 220, 30));

        pass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pass.setPreferredSize(new java.awt.Dimension(8, 20));
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        Main.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 220, 30));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Main.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 220, 40));

        jLabel3.setBackground(new java.awt.Color(0, 0, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setText("Don't have an account?");
        Main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Sign up");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        Main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Your stay starts here! Log in to book now.");
        Main.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Malaya Stays");
        Main.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 250, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 440));

        getContentPane().add(Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (loginAcc(user.getText(), pass.getText())) { 
            if (!status.equals("Active")) {
                JOptionPane.showMessageDialog(null, "Account is not active!");
            } else {
                JOptionPane.showMessageDialog(null, "Login Success!");
                if (type.equals("Admin")) {
                    adminDashboard ads = new adminDashboard();
                    ads.setVisible(true);
                } else if (type.equals("User")) {
                    userDashboard usr = new userDashboard();
                    usr.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Account not found!");
                }
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login Failed!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
         RegistrationForm re = new RegistrationForm();
         re.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
