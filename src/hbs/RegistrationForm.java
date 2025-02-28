
package hbs;

import Config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class RegistrationForm extends javax.swing.JFrame {

 
    public RegistrationForm() {
        initComponents();
         this.setResizable(false);
    }

    public static String email, usn;
    
    public boolean duplicateCheck(){
    
    dbConnector dbc = new dbConnector();   
    try{
           String query = "SELECT * FROM tbl_user  WHERE u_user = '" + usr.getText() + "' OR u_email = '" + em.getText() + "'";
            ResultSet resultSet = dbc.getData(query);   
           
        if(resultSet.next()){              
            email = resultSet.getString("u_email");
            
            if(email.equals(em.getText())){
               JOptionPane.showMessageDialog(null,"Email already Exist!");
               em.setText("");
               }      
            usn = resultSet.getString("u_user");
             if(usn.equals(usr.getText())){
               JOptionPane.showMessageDialog(null,"Username already Exist!");
               usr.setText("");
               }
          
             return true;    
        }else    
            return false;
    }catch(SQLException ex){
        System.out.println(""+ex);
        return false;
    }
    
    }
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        MAIN = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ps = new javax.swing.JTextField();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        usr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ty = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 153));
        jLabel7.setText("Sign up");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MAIN.setBackground(new java.awt.Color(255, 255, 255));
        MAIN.setToolTipText("DDAS");
        MAIN.setPreferredSize(new java.awt.Dimension(800, 420));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Register  ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Account Type");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Username");

        fn.setPreferredSize(new java.awt.Dimension(50, 20));
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });

        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText("Password");

        jLabel5.setBackground(new java.awt.Color(0, 0, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setText("Already have an account?");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("Sign in");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MAINLayout = new javax.swing.GroupLayout(MAIN);
        MAIN.setLayout(MAINLayout);
        MAINLayout.setHorizontalGroup(
            MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel1))
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel3)
                .addGap(210, 210, 210)
                .addComponent(jLabel4))
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(ln, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel8)
                .addGap(213, 213, 213)
                .addComponent(jLabel2))
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(usr, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(em, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel9)
                .addGap(218, 218, 218)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(ps, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(ty, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addComponent(jLabel10))
        );
        MAINLayout.setVerticalGroup(
            MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ln, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(em, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ps, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)))
        );

        getContentPane().add(MAIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
           if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty() || usr.getText().isEmpty() ||
            ps.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All Fields are required!");
        } else if (!fn.getText().matches("[a-zA-Z ]+")) { // First name validation
            JOptionPane.showMessageDialog(null, "First name must contain only letters!");
            fn.setText("");
        } else if (!ln.getText().matches("[a-zA-Z ]+")) { // Last name validation
            JOptionPane.showMessageDialog(null, "Last name must contain only letters!");
            ln.setText("");
        } else if (!em.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) { // Email validation
            JOptionPane.showMessageDialog(null, "Please enter a valid email address!");
            em.setText("");
        } else if (ps.getText().length() < 8) { // Password length validation
            JOptionPane.showMessageDialog(null, "Password should have at least 8 characters!");
            ps.setText("");
        } else if (duplicateCheck()) { // Check for duplicate user
            System.out.println("Duplicate Exist");
        } else {
            dbConnector dbc = new dbConnector();
            int rowsAffected = dbc.insertData("INSERT INTO tbl_user(u_fname, u_lname, u_email, u_user, u_pass, u_type, u_status) " +
                "VALUES('" + fn.getText() + "', '" + ln.getText() + "', '" + em.getText() + "', '" + usr.getText() + "', " +
                "'" + ps.getText() + "','" + ty.getSelectedItem() + "', 'Pending')");

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Inserted Successfully!");
                LoginForm lf = new LoginForm();
                lf.setVisible(true);
                this.dispose();
            } else {
                String errorMessage = "Connection Error!";
                if (rowsAffected == 0) {
                    errorMessage = "Error inserting user. Likely a duplicate entry or other constraint violation.";
                }
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void tyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        RegistrationForm re = new RegistrationForm();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        LoginForm lg = new  LoginForm();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MAIN;
    private javax.swing.JTextField em;
    private javax.swing.JTextField fn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField ln;
    private javax.swing.JTextField ps;
    private javax.swing.JComboBox<String> ty;
    private javax.swing.JTextField usr;
    // End of variables declaration//GEN-END:variables
}
