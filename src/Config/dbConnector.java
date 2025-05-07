
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbConnector {
    
    private Connection connect;

      
        public dbConnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hbssdb", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
    
   //Function to retrieve data
        public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }     
        
        
      //Function to save data
        public int insertData(String sql){
            int result;
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
                result =1;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
                result =0;
            }
            return result;
        }  
        
        
        
        //Function to update data
     public int updateData(String sql) {
    int result = 0; // Default value for no rows updated
    try {
        PreparedStatement pst = connect.prepareStatement(sql);
        result = pst.executeUpdate(); // Executes the update and returns number of rows affected
        System.out.println(result + " rows updated.");
        pst.close();
    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex.getMessage());
    }
    return result;
}


    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
