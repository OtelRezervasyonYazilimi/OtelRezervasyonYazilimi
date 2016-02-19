
package dbcLib1;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oryPencereler.otelPencere;

public class vtbaglatisi {
    public static Connection conn = null;
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbName = "otelrezervasyonsistemi";
    private String driver = "com.mysql.jdbc.Driver";
    private String userName = "root"; 
    private String password = "";
    private ResultSet res;

    public vtbaglatisi() {
             if(conn==null){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url + dbName, userName, password);
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Bağlantı başarısız!");
        }
        }  
    }

  public ResultSet sqlSorgu(String sql){
        ResultSet data = null;
 try {
            PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
           data = pst.executeQuery();
          
          } catch (SQLException ex) {
            Logger.getLogger(otelPencere.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
        }
  
  public  void sqlislem(String sql) {
        try {
            com.mysql.jdbc.Statement smt = (com.mysql.jdbc.Statement) vtbaglatisi.conn.createStatement();
            smt.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Bişeyleri yanlış yaptın!");
            Logger.getLogger(vtbaglatisi.class.getName()).log(Level.SEVERE, null, ex);
     
        }
  }
  
  
}

