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
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author russe
 */
public class user_guestpage extends javax.swing.JFrame {

    /**
     * Creates new form adminDashboard
     */
    public user_guestpage() {
        initComponents();
        displayData();
        AllUsers();
        
        guesttable.getTableHeader().setFont(new Font("Segue UI", Font.BOLD, 12));
        guesttable.getTableHeader().setOpaque(false);
        guesttable.getTableHeader().setBackground(new Color(32, 136, 203));
        guesttable.getTableHeader().setBackground(new Color(255,255,255));
        guesttable.setRowHeight(30);
        
          searchpanel.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String keyword = searchuser.getText().trim();
        if (!keyword.isEmpty()) {
            searchGuest(keyword); // Call the modified guest search method
        } else {
            JOptionPane.showMessageDialog(user_guestpage.this, "Please enter a guest name or email.");
        }
    }
});
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
            totaluser.setText(" " + totalUsers);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
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
        guesttable.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Error searching for guest.");
    }
}
    
     
   public void displayData() {
    try {
        dbConnector dbc = new dbConnector();
        ResultSet rs = dbc.getData("SELECT g_id AS 'ID', g_fname AS 'First Name', g_lname AS 'Last Name', g_email AS 'Email', g_status AS 'Status' FROM guest");
        guesttable.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}
  public boolean duplicateCheck() {
    dbConnector dbc = new dbConnector();   
    try {
        String query = "SELECT * FROM guest WHERE g_email = '" + em.getText() + "'";
        ResultSet resultSet = dbc.getData(query);   

        if (resultSet.next()) {              
            String email = resultSet.getString("email");

            if (email.equalsIgnoreCase(em.getText())) {
                JOptionPane.showMessageDialog(null, "Email already exists!");
                em.setText("");
                return true;    
            }
        } 
        return false;
    } catch (SQLException ex) {
        System.out.println("Error: " + ex);
        return false;
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
        guesttable = new javax.swing.JTable();
        fn = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        st = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        totaluser = new javax.swing.JLabel();
        searchuser = new javax.swing.JTextField();
        searchpanel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        gid = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
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

        guesttable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        guesttable.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        guesttable.setFocusable(false);
        guesttable.setRowHeight(30);
        guesttable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        guesttable.getTableHeader().setReorderingAllowed(false);
        guesttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guesttableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(guesttable);

        fn.setBackground(new java.awt.Color(242, 242, 242));
        fn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        fn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        fn.setPreferredSize(new java.awt.Dimension(50, 20));
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setText("Email");

        em.setBackground(new java.awt.Color(242, 242, 242));
        em.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        em.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        em.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        em.setPreferredSize(new java.awt.Dimension(50, 20));
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setText("Last Name");

        ln.setBackground(new java.awt.Color(242, 242, 242));
        ln.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ln.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ln.setPreferredSize(new java.awt.Dimension(50, 20));
        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setText("Status");

        st.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        st.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        st.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        add.setBackground(new java.awt.Color(204, 0, 0));
        add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD ");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("First Name");

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));

        jPanel11.setBackground(new java.awt.Color(0, 51, 153));
        jPanel11.setPreferredSize(new java.awt.Dimension(200, 42));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(242, 242, 242));
        jLabel16.setText("Total Guest");

        totaluser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totaluser.setForeground(new java.awt.Color(242, 242, 242));
        totaluser.setText("#");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(totaluser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(totaluser, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        searchuser.setBackground(new java.awt.Color(242, 242, 242));
        searchuser.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        searchuser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchuser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        searchuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchuserActionPerformed(evt);
            }
        });

        searchpanel.setBackground(new java.awt.Color(204, 0, 0));
        searchpanel.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        searchpanel.setForeground(new java.awt.Color(255, 255, 255));
        searchpanel.setText("SEARCH");
        searchpanel.setBorder(null);
        searchpanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchpanelActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RESET");
        jButton1.setPreferredSize(new java.awt.Dimension(104, 38));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(searchuser, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchuser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setText("Guest ID");

        gid.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        gid.setForeground(new java.awt.Color(0, 51, 51));
        gid.setText("#");

        clear.setBackground(new java.awt.Color(255, 0, 0));
        clear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("CLEAR");
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 0, 0));
        update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("UPDATE");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 0, 0));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel15)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13)
                                .addComponent(st, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ln, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(em, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fn, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                            .addComponent(jLabel10)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(70, 70, 70)
                                .addComponent(gid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(gid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(9, 9, 9)
                        .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel14))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(ln, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(em, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 830, 460));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 820, 460));

        jPanel8.setBackground(new java.awt.Color(255, 204, 0));
        jPanel8.setForeground(new java.awt.Color(0, 102, 102));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel18.setText("GUEST INFORMATION PAGE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
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
   
    
    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
      
    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All Fields are required!");
        } else if (!fn.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "First name must contain only letters!");
            fn.setText("");
        } else if (!ln.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "Last name must contain only letters!");
            ln.setText("");
        } else if (!em.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address!");
            em.setText("");
        } else if (duplicateCheck()) {
            System.out.println("Duplicate Exist");
        } else {
            try {
                dbConnector dbc = new dbConnector();
                int rowsAffected = dbc.insertData("INSERT INTO guest (g_fname, g_lname, g_email, g_status) " +
                    "VALUES('" + fn.getText() + "', '" + ln.getText() + "', '" + em.getText() + "', 'Pending')");

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Guest registered successfully!");
                    // Optional: open another form or clear inputs
                    // this.dispose(); or clearFormFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Error inserting guest!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Unexpected error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_addActionPerformed

    private void guesttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guesttableMouseClicked
    int rowIndex = guesttable.getSelectedRow();

    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a guest!");
    } else {
        try {
            dbConnector dbc = new dbConnector();
            TableModel tbl = guesttable.getModel();

            // Get guest ID from the selected row
            int guestId = Integer.parseInt(tbl.getValueAt(rowIndex, 0).toString());

            ResultSet rs = dbc.getData("SELECT * FROM guest WHERE g_id = " + guestId);

            if (rs.next()) {
             
                gid.setText(String.valueOf(rs.getInt("g_id")));
                fn.setText(rs.getString("g_fname"));
                ln.setText(rs.getString("g_lname"));
                em.setText(rs.getString("g_email") != null ? rs.getString("g_email") : "");
                st.setSelectedItem(rs.getString("g_status")); // assuming gstatus is a JComboBox
                add.setEnabled(false);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
            System.out.println("SQL Error: " + ex);
        }
    }
    }//GEN-LAST:event_guesttableMouseClicked

    private void searchuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchuserActionPerformed

    private void searchpanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchpanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchpanelActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            // Call the method that loads all guest data
            displayData(); // Make sure you have this method

            // Reset and display the total number of guests
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalGuests FROM guest");

            if (rs.next()) {
                int totalGuests = rs.getInt("totalGuests");
               
                totaluser.setText(" " + totalGuests); // Update the total guest count label
                
            }

            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error resetting the guest table.");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
     add.setEnabled(true);
        gid.setText("");
        fn.setText("");
         ln.setText("");
         em.setText("");
         st.setSelectedItem(""); // assuming gstatus is a JComboBox
    }//GEN-LAST:event_clearMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
 add.setEnabled(true);
        gid.setText("");
        fn.setText("");
         ln.setText("");
         em.setText("");
         st.setSelectedItem(""); // assuming gstatus is a JComboBox
   
    }//GEN-LAST:event_clearActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
      if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "All fields are required!");
} else if (!fn.getText().matches("[a-zA-Z ]+")) {
    JOptionPane.showMessageDialog(null, "First name must contain only letters!");
    fn.setText("");
} else if (!ln.getText().matches("[a-zA-Z ]+")) {
    JOptionPane.showMessageDialog(null, "Last name must contain only letters!");
    ln.setText("");
} else if (!em.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
    JOptionPane.showMessageDialog(null, "Please enter a valid email address!");
    em.setText("");
} else {
    try {
        dbConnector dbc = new dbConnector();
        String sql = "UPDATE guest SET g_fname = '" + fn.getText() + "', " +
                     "g_lname = '" + ln.getText() + "', " +
                     "g_email = '" + em.getText() + "', " +
                     "g_status = '" + st.getSelectedItem().toString() + "' " +
                     "WHERE g_id = '" + gid.getText() + "'";

        int rows = dbc.updateData(sql);

        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Guest updated successfully!");
           add.setEnabled(true);
          gid.setText("");
        fn.setText("");
         ln.setText("");
         em.setText("");
         st.setSelectedItem(""); // assuming gstatus is a JComboBox
            
            
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Update failed. Please try again.");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}

    }//GEN-LAST:event_deleteMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (gid.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select a guest to delete!");
    } else {
        int confirm = JOptionPane.showConfirmDialog(null, 
            "Are you sure you want to delete this guest?", 
            "Confirm Deletion", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                dbConnector dbc = new dbConnector();
                String sql = "DELETE FROM guest WHERE g_id = '" + gid.getText() + "'";
                int rows = dbc.updateData(sql);

                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Guest deleted successfully!");
                    add.setEnabled(true);
                    gid.setText("");
                    fn.setText("");
                    ln.setText("");
                    em.setText("");
                    st.setSelectedItem(""); // clear status field
                } else {
                    JOptionPane.showMessageDialog(null, "Deletion failed. Please try again.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

    String firstName = fn.getText().trim();
    String lastName = ln.getText().trim();
    String email = em.getText().trim();
    String status = (String) st.getSelectedItem();
        
   if (gid.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select a guest to update first!");
        return;
    
    } else if (!firstName.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(null, "First name must contain only letters!");
        fn.setText("");
    } else if (!lastName.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(null, "Last name must contain only letters!");
        ln.setText("");
    } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address!");
        em.setText("");
    } else if (status == null || status.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select a valid status!");
    } else {
        try {
            dbConnector dbc = new dbConnector();
            String sql = "UPDATE guest SET g_fname = ?, g_lname = ?, g_email = ?, g_status = ? WHERE g_id = ?";
            PreparedStatement pst = dbc.connect.prepareStatement(sql);

            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, email);
            pst.setString(4, status);
            pst.setString(5, gid.getText());

            int rows = pst.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Guest updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Update failed. Please try again.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(user_guestpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_guestpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_guestpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_guestpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new user_guestpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    public javax.swing.JButton clear;
    public javax.swing.JButton delete;
    public javax.swing.JTextField em;
    private javax.swing.JTextField fn;
    public javax.swing.JLabel gid;
    public javax.swing.JTable guesttable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField ln;
    private javax.swing.JButton searchpanel;
    private javax.swing.JTextField searchuser;
    private javax.swing.JLabel settings;
    public javax.swing.JComboBox<String> st;
    private javax.swing.JLabel totaluser;
    public javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
