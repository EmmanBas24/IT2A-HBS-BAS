/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import user.*;
import Config.Session;
import Config.dbConnector;
import hbs.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author PATENIORICAMAEB(MING
 */
public class bookingpage extends javax.swing.JFrame {

    /**
     * Creates new form user_bookingpage
     */
    public bookingpage() {
        initComponents();
       
      
        
         comboStatus.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        displayData(); // Refresh the table when the selection changes
    }
});
        
        
        
    }
public void displayData() {
    try {
        dbConnector dbc = new dbConnector();
        String selectedStatus = comboStatus.getSelectedItem().toString();

        String query = "SELECT " +
                       "b.booking_id AS 'Booking ID', " +
                       "r.room_id AS 'Room ID', " +
                       "g.g_fname AS 'First Name', " +
                       "g.g_lname AS 'Last Name', " +
                       "g.g_email AS 'Email', " +
                       "rc.category_name AS 'Room Category', " +
                       "b.check_in_date AS 'Check-In', " +
                       "b.check_out_date AS 'Check-Out', " +
                       "b.b_status AS 'Booking Status' " +
                       "FROM tbl_booking b " +
                       "JOIN guest g ON b.g_id = g.g_id " +
                       "JOIN tbl_rooms r ON b.room_id = r.room_id " +
                       "JOIN room_category rc ON r.rc_id = rc.rc_id";

        if (!selectedStatus.equalsIgnoreCase("All")) {
            query += " WHERE b.b_status = '" + selectedStatus.toLowerCase() + "'";
        }

        query += " ORDER BY b.booking_id DESC"; // Descending order

        ResultSet rs = dbc.getData(query);
        bookingtable.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}





   
  

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookingtable = new javax.swing.JTable();
        cancel = new javax.swing.JButton();
        comboStatus = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 204, 0));
        jPanel8.setForeground(new java.awt.Color(0, 102, 102));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 3, 18)); // NOI18N
        jLabel18.setText("HOTEL BOOKING SYSTEM");

        id.setForeground(new java.awt.Color(255, 204, 0));
        id.setText("jLabel17");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(442, Short.MAX_VALUE)
                .addComponent(id)
                .addGap(78, 78, 78)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(id))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

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

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 109, 780, 330);

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel Booking");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel);
        cancel.setBounds(410, 50, 115, 34);

        comboStatus.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Confirmed", "Pending", "Checked-In", "Checked-Out", "Cancelled" }));
        jPanel2.add(comboStatus);
        comboStatus.setBounds(630, 40, 150, 40);

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 3, 18)); // NOI18N
        jLabel19.setText("HOTEL BOOKING SYSTEM");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(50, 40, 222, 25);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 800, 450));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 0));
        jLabel15.setText("Dashboard");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Manage Rooms");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Users");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
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

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Settings");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SW Hotel");

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(242, 242, 242));
        jLabel14.setText("Room Category");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(58, 58, 58))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bookingtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingtableMouseClicked
   
    }//GEN-LAST:event_bookingtableMouseClicked
  
    private int CurrentUserId() {
    // Access the user ID from the SessionClass
      dbConnector dbc = new dbConnector();
      Session sess = Session.getInstance();
    return sess.getUid();
}
    private Date removeTime(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    return cal.getTime();
}
    
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
          int selectedRow = bookingtable.getSelectedRow(); // Replace with your JTable variable name

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a booking to cancel.", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String bookingId = bookingtable.getValueAt(selectedRow, 0).toString(); // Adjust column index if needed
    dbConnector dbc = new dbConnector();

    try {
        // Get room_id and g_id for the selected booking
        ResultSet rs = dbc.getData("SELECT room_id, g_id FROM tbl_booking WHERE booking_id = " + bookingId);
        if (rs.next()) {
            String roomId = rs.getString("room_id");
            String guestId = rs.getString("g_id");

            // Update booking status to "Cancelled"
            int updateBooking = dbc.updateData("UPDATE tbl_booking SET b_status = 'Cancelled' WHERE booking_id = " + bookingId);

            // Update room status to "Available"
            int updateRoom = dbc.updateData("UPDATE tbl_rooms SET room_status = 'Available' WHERE room_id = " + roomId);

            // Update guest status to "Inactive"
            int updateGuest = dbc.updateData("UPDATE guest SET g_status = 'Inactive' WHERE g_id = " + guestId);

            if (updateBooking > 0 && updateRoom > 0 && updateGuest > 0) {
                JOptionPane.showMessageDialog(null, "Booking has been successfully cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);              
            } else {
                JOptionPane.showMessageDialog(null, "Cancellation failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Booking details not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "An error occurred while cancelling the booking: " + e.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_cancelActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
          Session sess = Session.getInstance();
     id.setText(""+sess.getUid());
    }//GEN-LAST:event_formWindowActivated

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        adminDashboard ad = new adminDashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Manage_room mr = new Manage_room();
        mr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        UserForms uf = new UserForms();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            LoginForm lf = new LoginForm ();
            lf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        admin_settings se = new admin_settings();
        se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        roomcategory rc = new roomcategory();
        rc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

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
            java.util.logging.Logger.getLogger(bookingpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookingpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookingpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookingpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookingpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable bookingtable;
    private javax.swing.JButton cancel;
    public javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
