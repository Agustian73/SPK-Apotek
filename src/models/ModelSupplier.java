

package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Koneksi;


public class ModelSupplier extends Koneksi{
    public ResultSet read(){
        ResultSet i = null;
        String sql = "Select * FROM supplier";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            i = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int insert(String []param){
        int i =0;
        String sql="insert into supplier values(?,?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);
            i = p.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(ModelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int update(String []param){
        int i = 0;
        String sql = "UPDATE supplier SET nama_supplier=?, alamat_supplier=?, no_telpon=? WHERE kd_supplier=?";        
        try {
           PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int delete(String []param){
        int i = 0;
        String sql = "DELETE FROM supplier WHERE kd_supplier=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }   
}
