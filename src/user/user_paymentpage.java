/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import Config.Session;
import Config.dbConnector;
import admin.admin_user_update;
import hbs.LoginForm;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author russe
 */
public class user_paymentpage extends javax.swing.JFrame {

    /**
     * Creates new form adminDashboard
     */
    public user_paymentpage() {
        initComponents();
        displayData();
     
        
        bookingtable.getTableHeader().setFont(new Font("Segue UI", Font.BOLD, 12));
        bookingtable.getTableHeader().setOpaque(false);
        bookingtable.getTableHeader().setBackground(new Color(32, 136, 203));
        bookingtable.getTableHeader().setBackground(new Color(255,255,255));
        bookingtable.setRowHeight(30);
        
        statusCombo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        displayData(); // Refresh the table when the selection changes
    }
});
        
  
    }
    
    
    
    private void logUserDeletionAction(int loggedInUserId, String loggedInUsername, String deletedUsername) {
        String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

        dbConnector db = new dbConnector();
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, loggedInUserId);
            pstmt.setString(2, loggedInUsername + " deleted a user: " + deletedUsername);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Failed to log user deletion action: " + e.getMessage());
        }
    }
    
     private int getCurrentUserId() {
        // Access the user ID from the SessionClass
        Config.Session ses = Config.Session.getInstance();
        return ses.getUid();
    }
    
 private void searchGuest(String keyword) {
    try {
        dbConnector dbc = new dbConnector();
        String sql = "SELECT g_id AS 'ID', g_fname AS 'First Name', g_lname AS 'Last Name', g_email AS 'Email', g_status AS 'Status' " +
                     "FROM guest WHERE g_fname LIKE '%" + keyword + "%' OR g_lname LIKE '%" + keyword + "%' OR g_email LIKE '%" + keyword + "%'";
        
        ResultSet rs = dbc.getData(sql);
        bookingtable.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Error searching for guest.");
    }
}
    
     
  public void displayData() {
    try {
        String selectedStatus = statusCombo.getSelectedItem().toString(); // Get the selected status

        dbConnector dbc = new dbConnector();
        ResultSet rs = dbc.getData(
            "SELECT " +
            "b.booking_id AS 'Booking ID', " +
            "g.g_fname AS 'First Name', " +
            "g.g_lname AS 'Last Name', " +
            "r.room_id AS 'Room ID', " +
            "r.price_per_night AS 'Room Price', " +
            "b.check_in_date AS 'Check-In Date', " +
            "b.check_out_date AS 'Check-Out Date', " +
            "b.b_status AS 'Booking Status' " +
            "FROM tbl_booking b " +
            "JOIN guest g ON b.g_id = g.g_id " +
            "JOIN tbl_rooms r ON b.room_id = r.room_id " +
            "WHERE b.b_status = '" + selectedStatus.toLowerCase() + "'" // Use the selected status
        );

        bookingtable.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}
  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookingtable = new javax.swing.JTable();
        addpayment = new javax.swing.JButton();
        GenerateReciept = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        daysField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        methodField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        amountPaidField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        statusCombo = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        settings = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 334, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookingtable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        bookingtable.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        bookingtable.setFocusable(false);
        bookingtable.setRowHeight(30);
        bookingtable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        bookingtable.getTableHeader().setReorderingAllowed(false);
        bookingtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookingtable);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 202, 790, 240));

        addpayment.setBackground(new java.awt.Color(204, 0, 0));
        addpayment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addpayment.setForeground(new java.awt.Color(255, 255, 255));
        addpayment.setText("Payment Complete");
        addpayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addpaymentMouseClicked(evt);
            }
        });
        addpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpaymentActionPerformed(evt);
            }
        });
        jPanel6.add(addpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 150, 37));

        GenerateReciept.setBackground(new java.awt.Color(255, 0, 0));
        GenerateReciept.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GenerateReciept.setForeground(new java.awt.Color(255, 255, 255));
        GenerateReciept.setText("Generate Reciept");
        GenerateReciept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenerateRecieptMouseClicked(evt);
            }
        });
        GenerateReciept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateRecieptActionPerformed(evt);
            }
        });
        jPanel6.add(GenerateReciept, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 150, 37));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("Payment Method:");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 110, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setText("Name:");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        totalField.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        totalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.add(totalField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 141, 34));

        nameField.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        jPanel6.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 16, 141, 34));

        jTextField4.setText("jTextField1");
        jPanel6.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 16, 141, 34));

        daysField.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        daysField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        daysField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        daysField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daysFieldActionPerformed(evt);
            }
        });
        jPanel6.add(daysField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 141, 34));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setText("No of Days: ");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 34));

        methodField.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        methodField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        methodField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.add(methodField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 141, 34));

        priceField.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        priceField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 141, 34));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setText("Room Price:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setText("Total Bill:");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 30));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setText("Payment Status:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 110, 30));

        amountPaidField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amountPaidField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.add(amountPaidField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 141, 34));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("Amount Paid:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 110, 30));

        statusComboBox.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid" }));
        jPanel6.add(statusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 140, 30));

        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Confirmed" }));
        jPanel6.add(statusCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 180, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 460));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 830, 460));

        jPanel8.setBackground(new java.awt.Color(255, 204, 0));
        jPanel8.setForeground(new java.awt.Color(0, 102, 102));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel18.setText("PAYMENT PAGE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(318, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(356, 356, 356))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 830, 40));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Dashboard");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText(" Log out");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        settings.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        settings.setForeground(new java.awt.Color(242, 242, 242));
        settings.setText("Settings");
        settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("SW Hotel");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Bookings");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Rooms");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Guests");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Room Category");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(242, 242, 242));
        jLabel20.setText("Payment");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(settings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(47, 47, 47))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session sess = Session.getInstance();
     if(sess.getUid()== 0){
      JOptionPane.showMessageDialog(null, "No account found, must login!");
      LoginForm lf = new LoginForm();
      lf.setVisible(true);
      this.dispose();
     }
     //acc_name.setText(""+sess.getFname());
    }//GEN-LAST:event_formWindowActivated
   
    
    private void addpaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addpaymentMouseClicked
      
         if (nameField.getText().isEmpty() || 
        daysField.getText().isEmpty() || 
        priceField.getText().isEmpty() || 
        totalField.getText().isEmpty() || 
        methodField.getText().isEmpty() || 
        amountPaidField.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "All fields are required!");
        return;
    }

    double amountPaid, totalBill;
    try {
        amountPaid = Double.parseDouble(amountPaidField.getText());
        totalBill = Double.parseDouble(totalField.getText());
        
        if (amountPaid < totalBill) {
            JOptionPane.showMessageDialog(null, "Amount paid is less than the total bill!");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Amount Paid and Total Bill must be numeric!");
        return;
    }

    int rowIndex = bookingtable.getSelectedRow();
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a booking from the table!");
        return;
    }

    try {
        TableModel tbl = bookingtable.getModel();
        int bookingId = Integer.parseInt(tbl.getValueAt(rowIndex, 0).toString()); // Booking ID

        // Assuming you have a way to get the current user/staff ID
        int handledBy = getCurrentUserId(); // Replace with actual method or value

        dbConnector dbc = new dbConnector();
        Connection conn = dbc.getConnection(); 
        String insertQuery = "INSERT INTO payment (booking_id, amount, payment_method, payment_status, payment_date, handled_by) " +
                             "VALUES (?, ?, ?, ?, NOW(), ?)";

        PreparedStatement ps = dbc.getConnection().prepareStatement(insertQuery);
        ps.setInt(1, bookingId);
        ps.setDouble(2, amountPaid);
        ps.setString(3, methodField.getText());
        ps.setString(4, statusComboBox.getSelectedItem().toString());
        ps.setInt(5, handledBy); // Your logged-in user ID

        int result = ps.executeUpdate();

        if (result > 0) {
            String updateQuery = "UPDATE tbl_booking SET b_status = 'Confirmed' WHERE booking_id = ?";
            PreparedStatement ps2 = dbc.getConnection().prepareStatement(updateQuery);
            ps2.setInt(1, bookingId);
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(null, "Payment added successfully!");

            // Clear fields
            nameField.setText("");
            daysField.setText("");
            priceField.setText("");
            totalField.setText("");
            methodField.setText("");
            amountPaidField.setText("");
            statusComboBox.setSelectedIndex(0);

            displayData();
        } else {
            JOptionPane.showMessageDialog(null, "Failed to insert payment!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
        
    }//GEN-LAST:event_addpaymentMouseClicked

    private void addpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpaymentActionPerformed

    }//GEN-LAST:event_addpaymentActionPerformed

    private void bookingtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingtableMouseClicked
   
        int rowIndex = bookingtable.getSelectedRow();

if (rowIndex < 0) {
    JOptionPane.showMessageDialog(null, "Please select a booking!");
} else {
    TableModel tbl = bookingtable.getModel();

    // Extracting values from table
    String firstName = tbl.getValueAt(rowIndex, 1).toString(); // First Name
    String lastName = tbl.getValueAt(rowIndex, 2).toString();  // Last Name
    String roomPriceStr = tbl.getValueAt(rowIndex, 4).toString(); // Room Price
    String checkIn = tbl.getValueAt(rowIndex, 5).toString();
    String checkOut = tbl.getValueAt(rowIndex, 6).toString();

    // Combine full name
    String fullName = firstName + " " + lastName;
    nameField.setText(fullName);

    // Calculate number of days
    try {
        LocalDate inDate = LocalDate.parse(checkIn);
        LocalDate outDate = LocalDate.parse(checkOut);
        long daysBetween = ChronoUnit.DAYS.between(inDate, outDate);

        // Display number of days
        daysField.setText(String.valueOf(daysBetween));

        // Display room price
        double roomPrice = Double.parseDouble(roomPriceStr);
        priceField.setText(String.format("%.2f", roomPrice));

        // Compute total bill
        double total = daysBetween * roomPrice;
        totalField.setText(String.format("%.2f", total));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Date format error: " + e.getMessage());
    }
}

        
    }//GEN-LAST:event_bookingtableMouseClicked

    private void GenerateRecieptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerateRecieptMouseClicked
    
    int rowIndex = bookingtable.getSelectedRow();

    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select an item!");
    } else {
        try {
            dbConnector dbc = new dbConnector();
            TableModel tbl = bookingtable.getModel();
            String bookingId = tbl.getValueAt(rowIndex, 0).toString();

            String query = "SELECT p.payment_id, b.booking_id, rc.category_name AS room_name, " +
                           "CONCAT(g.g_fname, ' ', g.g_lname) AS guest_name, g.g_email, " +
                           "b.check_in_date, b.check_out_date, " +
                           "DATEDIFF(b.check_out_date, b.check_in_date) AS num_days, " +
                           "p.payment_date, p.payment_status, p.amount AS total_amount " +
                           "FROM payment p " +
                           "JOIN tbl_booking b ON p.booking_id = b.booking_id " +
                           "JOIN guest g ON b.g_id = g.g_id " +
                           "JOIN tbl_rooms r ON b.room_id = r.room_id " +
                           "JOIN room_category rc ON r.rc_id = rc.rc_id " +
                           "WHERE b.booking_id = '" + bookingId + "'";

            ResultSet rs = dbc.getData(query);

            if (rs.next()) {
               Receiptt receipt = new Receiptt();

                receipt.paymentId.setText(rs.getString("payment_id"));
                receipt.bookingId.setText(rs.getString("booking_id"));
                receipt.roomName.setText(rs.getString("room_name"));
                receipt.guestName.setText(rs.getString("guest_name"));
                receipt.guestEmail.setText(rs.getString("g_email"));
                receipt.checkIn.setText(rs.getString("check_in_date"));
                receipt.checkOut.setText(rs.getString("check_out_date"));
                receipt.numDays.setText(rs.getString("num_days") + " day(s)");
                receipt.paymentDate.setText(rs.getString("payment_date"));
                receipt.paymentStatus.setText(rs.getString("payment_status"));
                receipt.totalAmount.setText(rs.getString("total_amount"));

                receipt.setVisible(true);
               
            } else {
                JOptionPane.showMessageDialog(null, "No receipt data found for this booking.");
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
    }


    }//GEN-LAST:event_GenerateRecieptMouseClicked

    private void GenerateRecieptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateRecieptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenerateRecieptActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        userDashboard ud = new userDashboard();
        ud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseClicked
        user_settings us = new user_settings();
        us.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_settingsMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        user_bookingpage bp = new user_bookingpage();
        bp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        user_roompage rp = new user_roompage();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        user_guestpage gp = new user_guestpage();
        gp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        user_roomcategorypage rc = new user_roomcategorypage();
        rc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        user_paymentpage rc = new user_paymentpage();
        rc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void daysFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daysFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daysFieldActionPerformed

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
            java.util.logging.Logger.getLogger(user_paymentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_paymentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_paymentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_paymentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_paymentpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton GenerateReciept;
    public javax.swing.JButton addpayment;
    private javax.swing.JTextField amountPaidField;
    public javax.swing.JTable bookingtable;
    private javax.swing.JTextField daysField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField methodField;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel settings;
    private javax.swing.JComboBox<String> statusCombo;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}
