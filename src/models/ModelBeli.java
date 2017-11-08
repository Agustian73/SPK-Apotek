
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Koneksi;


public class ModelBeli extends Koneksi{  
    public int insert(String [] param){
        int i = 0;
        String sql = "INSERT INTO trans_beli VALUES(?,?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            p.setString(3, param[2]);               
            p.setString(4, param[3]);               
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int insert_beli(String [] param){
        int i = 0;
        String sql = "INSERT INTO beli VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);            
            p.setString(5, param[4]);            
            p.setString(6, param[5]);            
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }    
    public ResultSet readSupp(){
        ResultSet i = null;
        String sql = "Select * FROM supplier";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            i = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }    
      public ResultSet selectJenis(String nama) {
        ResultSet  r = null;        
        String sql = "SELECT * FROM supplier where nama_supplier= '"+nama+"'";
        try {
            PreparedStatement p = con.prepareStatement(sql);                    
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
 }
