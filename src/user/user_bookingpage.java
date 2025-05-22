/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

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
public class user_bookingpage extends javax.swing.JFrame {

    /**
     * Creates new form user_bookingpage
     */
    public user_bookingpage() {
        initComponents();
       
        AllUsers();
        
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





   public void AllUsers() {
    try {
        // Connect to the database
        dbConnector dbc = new dbConnector();
        
        // Query to get the total number of users
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalusers FROM guest");
        
        if (rs.next()) {
            // Retrieve the total count from the query result
            int totalUsers = rs.getInt("totalusers");
            
            // Assuming you have a JLabel named lblTotalUsers to display the count
             totalbooking.setText(" " + totalUsers);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
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
        addbooking = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        cin = new com.toedter.calendar.JDateChooser();
        cout = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        totalbooking = new javax.swing.JLabel();
        checkin = new javax.swing.JButton();
        checkout = new javax.swing.JButton();
        comboStatus = new javax.swing.JComboBox<>();
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
                .addContainerGap(472, Short.MAX_VALUE)
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

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 830, 50));

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
        jScrollPane1.setBounds(10, 218, 810, 221);

        addbooking.setBackground(new java.awt.Color(255, 0, 0));
        addbooking.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        addbooking.setForeground(new java.awt.Color(255, 255, 255));
        addbooking.setText("ADD BOOKING");
        addbooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbookingMouseClicked(evt);
            }
        });
        addbooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbookingActionPerformed(evt);
            }
        });
        jPanel2.add(addbooking);
        addbooking.setBounds(200, 160, 110, 40);

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
        cancel.setBounds(680, 110, 115, 34);

        cin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(cin);
        cin.setBounds(386, 38, 191, 30);

        cout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(cout);
        cout.setBounds(386, 102, 191, 30);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel1.setText("Guest ID");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 11, 54, 20);

        fn.setBackground(new java.awt.Color(242, 242, 242));
        fn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel2.add(fn);
        fn.setBounds(192, 38, 162, 31);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel8.setText("Guest Name");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(190, 10, 77, 30);

        gid.setBackground(new java.awt.Color(242, 242, 242));
        gid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(gid);
        gid.setBounds(10, 37, 125, 32);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel10.setText("Guest Email");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(190, 70, 80, 30);

        em.setBackground(new java.awt.Color(242, 242, 242));
        em.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel2.add(em);
        em.setBounds(190, 100, 160, 30);

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel11.setText("Check in Date");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(390, 10, 87, 30);

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel12.setText("Check out Date");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(390, 70, 96, 30);

        rid.setBackground(new java.awt.Color(242, 242, 242));
        rid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(rid);
        rid.setBounds(10, 101, 125, 32);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/square-plus.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel14);
        jLabel14.setBounds(139, 37, 32, 32);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/square-plus.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel15);
        jLabel15.setBounds(139, 101, 32, 32);

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel16.setText("Room ID");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(10, 75, 55, 20);

        jPanel11.setBackground(new java.awt.Color(0, 51, 153));
        jPanel11.setPreferredSize(new java.awt.Dimension(200, 42));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(242, 242, 242));
        jLabel17.setText("Total Bookings");

        totalbooking.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalbooking.setForeground(new java.awt.Color(242, 242, 242));
        totalbooking.setText("#");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(totalbooking, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(totalbooking, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel11);
        jPanel11.setBounds(10, 165, 164, 34);

        checkin.setBackground(new java.awt.Color(255, 0, 0));
        checkin.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        checkin.setForeground(new java.awt.Color(255, 255, 255));
        checkin.setText("Check In");
        checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinActionPerformed(evt);
            }
        });
        jPanel2.add(checkin);
        checkin.setBounds(680, 10, 115, 34);

        checkout.setBackground(new java.awt.Color(255, 0, 0));
        checkout.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        checkout.setForeground(new java.awt.Color(255, 255, 255));
        checkout.setText("Check-Out");
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        jPanel2.add(checkout);
        checkout.setBounds(680, 60, 115, 34);

        comboStatus.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Confirmed", "Pending", "Checked-In", "Checked-Out", "Cancelled" }));
        jPanel2.add(comboStatus);
        comboStatus.setBounds(660, 170, 150, 40);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 830, 450));

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
    int rowIndex = bookingtable.getSelectedRow();

    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a booking record!");
    } else {
        try {
            TableModel model = bookingtable.getModel();
            dbConnector dbc = new dbConnector();

            int guestId = Integer.parseInt(model.getValueAt(rowIndex, 0).toString()); // g_id column 0
            int roomId = Integer.parseInt(model.getValueAt(rowIndex, 1).toString());  // room_id column 1
            String checkInStr = model.getValueAt(rowIndex, 6).toString();              // check-in date string
            String checkOutStr = model.getValueAt(rowIndex, 7).toString();             // check-out date string

            // Convert string dates to java.util.Date objects
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // adjust the format to your date string format
            
            Date checkInDate = null;
            Date checkOutDate = null;

            try {
                checkInDate = sdf.parse(checkInStr);
                checkOutDate = sdf.parse(checkOutStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Date parsing error: " + e.getMessage());
            }

            // Fetch guest details from DB
            ResultSet rs = dbc.getData("SELECT * FROM guest WHERE g_id = " + guestId);

            if (rs.next()) {
                String fullName = rs.getString("g_fname") + " " + rs.getString("g_lname");
                String email = rs.getString("g_email");

                gid.setText(String.valueOf(guestId));
                rid.setText(String.valueOf(roomId));
                fn.setText(fullName);
                em.setText(email != null ? email : "");
                
                if (checkInDate != null) {
                    cin.setDate(checkInDate);   // set the date on JDateChooser
                }
                if (checkOutDate != null) {
                    cout.setDate(checkOutDate); // set the date on JDateChooser
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
            System.out.println("SQL Error: " + ex);
        }
    }
    }//GEN-LAST:event_bookingtableMouseClicked
  
    private int CurrentUserId() {
    // Access the user ID from the SessionClass
      dbConnector dbc = new dbConnector();
      Session sess = Session.getInstance();
    return sess.getUid();
}
    private void addbookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbookingActionPerformed
        if (cin.getDate() == null || cout.getDate() == null || 
        gid.getText().isEmpty() || rid.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please ensure that all required fields are properly filled in.", "Missing Information", JOptionPane.WARNING_MESSAGE);
    } else {
        try {
            Date checkInDate = cin.getDate();
            Date checkOutDate = cout.getDate();
            Date today = new Date();

            // Validation: check-in date should not be before today
            if (checkInDate.before(removeTime(today))) {
                JOptionPane.showMessageDialog(null, "The check-in date must not be a past date. Kindly select a valid check-in date.", "Invalid Check-In Date", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validation: check-out date must be after check-in date
            if (!checkOutDate.after(checkInDate)) {
                JOptionPane.showMessageDialog(null, "The check-out date must be later than the check-in date. Kindly review your selected dates.", "Invalid Check-Out Date", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Format the dates
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String checkIn = sdf.format(checkInDate);
            String checkOut = sdf.format(checkOutDate);

            // Get values from fields
            String guestId = gid.getText().trim();
            String roomId = rid.getText().trim();
            String userId = id.getText().trim(); // User ID from logged-in user

            dbConnector dbc = new dbConnector();

            // Insert booking
            int bookingInserted = dbc.insertData(
                "INSERT INTO tbl_booking (g_id, u_id, check_in_date, check_out_date, b_status, room_id) " +
                "VALUES (" + guestId + ", " + userId + ", '" + checkIn + "', '" + checkOut + "', 'Pending', " + roomId + ")"
            );

            if (bookingInserted > 0) {
                // ✅ Update guest status to Active
                dbc.updateData("UPDATE guest SET g_status = 'Active' WHERE g_id = " + guestId);

                JOptionPane.showMessageDialog(null, "The booking has been successfully recorded. Thank you!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "An error occurred while processing the booking. Please try again.", "Booking Failed", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An unexpected error has occurred: " + ex.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_addbookingActionPerformed

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

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
       this.dispose();
       GuestTABLE rt = new GuestTABLE();
       rt.setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
      RoomTable rt = new RoomTable();
       rt.setVisible(true);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void addbookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbookingMouseClicked
      
    }//GEN-LAST:event_addbookingMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
          Session sess = Session.getInstance();
     id.setText(""+sess.getUid());
    }//GEN-LAST:event_formWindowActivated

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        userDashboard ud = new userDashboard();
        ud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
             LoginForm lf = new LoginForm ();
            lf.setVisible(true);
            this.dispose();
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

    private void checkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinActionPerformed
      int selectedRow = bookingtable.getSelectedRow(); // Replace with your actual JTable name

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a booking from the table first.", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Assuming booking ID is in column 0 (adjust if necessary)
    String bookingId = bookingtable.getValueAt(selectedRow, 0).toString();

    dbConnector dbc = new dbConnector();

    try {
        // First, check the current status of the booking
        ResultSet statusRs = dbc.getData("SELECT b_status FROM tbl_booking WHERE booking_id = " + bookingId);
        if (statusRs.next()) {
            String currentStatus = statusRs.getString("b_status");

            if (!"Confirmed".equalsIgnoreCase(currentStatus)) {
                JOptionPane.showMessageDialog(null, "You can only check in bookings with status 'Confirmed'.", "Invalid Booking Status", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Booking not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update booking status to 'Checked-In'
        int result = dbc.updateData("UPDATE tbl_booking SET b_status = 'Checked-In' WHERE booking_id = " + bookingId);

        if (result > 0) {
            JOptionPane.showMessageDialog(null, "The guest has been successfully checked in.", "Check-In Successful", JOptionPane.INFORMATION_MESSAGE);

            // Optional: also update room status to 'Occupied'
            ResultSet rs = dbc.getData("SELECT room_id FROM tbl_booking WHERE booking_id = " + bookingId);
            if (rs.next()) {
                String roomId = rs.getString("room_id");
                dbc.updateData("UPDATE tbl_rooms SET room_status = 'Occupied' WHERE room_id = " + roomId);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Check-in failed. Please try again.", "Failed", JOptionPane.ERROR_MESSAGE);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_checkinActionPerformed

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
     int selectedRow = bookingtable.getSelectedRow(); // Replace with your JTable variable name

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a booking from the table to check out.", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String bookingId = bookingtable.getValueAt(selectedRow, 0).toString(); // Adjust column index if needed
    dbConnector dbc = new dbConnector();

    try {
        // Check current booking status
        ResultSet statusRs = dbc.getData("SELECT b_status FROM tbl_booking WHERE booking_id = " + bookingId);
        if (statusRs.next()) {
            String currentStatus = statusRs.getString("b_status");

            if (!"Checked-In".equalsIgnoreCase(currentStatus)) {
                JOptionPane.showMessageDialog(null, "Only bookings with status 'Checked-In' can be checked out.", "Invalid Booking Status", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Booking not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get room_id and guest_id from the booking
        ResultSet rs = dbc.getData("SELECT room_id, g_id FROM tbl_booking WHERE booking_id = " + bookingId);
        if (rs.next()) {
            String roomId = rs.getString("room_id");
            String guestId = rs.getString("g_id");

            // Update booking status to Checked-Out
            int updateBooking = dbc.updateData("UPDATE tbl_booking SET b_status = 'Checked-Out' WHERE booking_id = " + bookingId);

            // Update room status to Available
            int updateRoom = dbc.updateData("UPDATE tbl_rooms SET room_status = 'Available' WHERE room_id = " + roomId);

            // Update guest status to Inactive
            int updateGuest = dbc.updateData("UPDATE guest SET g_status = 'Inactive' WHERE g_id = " + guestId);

            if (updateBooking > 0 && updateRoom > 0 && updateGuest > 0) {
                JOptionPane.showMessageDialog(null, "The guest has been successfully checked out and set to Inactive.", "Check-Out Successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Check-out failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Room or guest information not found for this booking.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "An error occurred during check-out: " + e.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_checkoutActionPerformed

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
            java.util.logging.Logger.getLogger(user_bookingpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_bookingpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_bookingpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_bookingpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_bookingpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbooking;
    public javax.swing.JTable bookingtable;
    private javax.swing.JButton cancel;
    private javax.swing.JButton checkin;
    private javax.swing.JButton checkout;
    private com.toedter.calendar.JDateChooser cin;
    public javax.swing.JComboBox<String> comboStatus;
    private com.toedter.calendar.JDateChooser cout;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JTextField gid;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField rid;
    private javax.swing.JLabel settings;
    private javax.swing.JLabel totalbooking;
    // End of variables declaration//GEN-END:variables
}
