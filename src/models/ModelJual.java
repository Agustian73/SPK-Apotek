

package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Koneksi;


public class ModelJual extends Koneksi{
    public ResultSet read(){
        ResultSet r = null;
        String sql = "SELECT jual.kd_jual, DATE_FORMAT(jual.tgl_jual,'%d-%m-%Y') AS tgl, persediaan.kd_barang,"
                + " persediaan.nm_barang, persediaan.satuan, format(persediaan.hrg_jual,0) AS hrg_jual, jual.jml_jual, format(jual.total,0) AS total FROM jual ,persediaan WHERE jual.kd_barang=persediaan.kd_barang";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ModelJual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public int insert(String [] param){
        int i = 0;
        String sql = "INSERT INTO jual VALUES(?,?,?,?,?,?)";
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
            Logger.getLogger(ModelJual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int update(String [] param){
        int i = 0;
        String sql = "UPDATE jual SET kd_barang=?, hrg_jual=?, jml_jual=?, total=?, tgl_jual=? WHERE kd_jual=?";
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
            Logger.getLogger(ModelJual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int delete(String [] param){
        int i = 0;
        String sql = "DELETE FROM jual WHERE kd_jual=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelJual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public String generate(){
        String id = "";       
        String sql = "SELECT kd_jual FROM jual ORDER BY kd_jual DESC";
        try{
            PreparedStatement p = con.prepareStatement(sql);  
            ResultSet resultSet = p.executeQuery(sql);
            if(resultSet.next()){
                id = resultSet.getString(1);
            }
        }catch(SQLException e){            
        }
        return id;
    }
      public ResultSet ambil(String kd) {
        ResultSet  r = null;        
        String sql = "SELECT stok FROM persediaan where kd_barang= '"+kd+"'";
        try {
            PreparedStatement p = con.prepareStatement(sql);                    
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelJual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
      public ResultSet validasi(String kd, String tanggal) {
        ResultSet  r = null;        
        String sql = "SELECT * FROM jual WHERE kd_barang= '"+kd+"' AND tgl_jual= '"+tanggal+"'";
        try {
            PreparedStatement p = con.prepareStatement(sql);                    
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelJual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
      public ResultSet pilih(String kode) {
        ResultSet  r = null;              
        String sql = "SELECT * FROM jual WHERE kd_jual= '"+kode+"'";
        try {
            PreparedStatement p = con.prepareStatement(sql);                    
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelJual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
