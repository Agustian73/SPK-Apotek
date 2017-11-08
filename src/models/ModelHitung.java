

package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Koneksi;

public class ModelHitung extends Koneksi{
    public ResultSet ambil_kode() {
        ResultSet r = null;
        String sql = "SELECT * from jual group by kd_barang";
       try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }    
    public ResultSet tgl_max() {
        ResultSet r = null;       
        String sql = "SELECT MAX(tgl_jual) AS tgl_jual FROM jual";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }    
    public ResultSet tampil_data() {
        ResultSet r = null;
        String sql = "SELECT * FROM persediaan, peramalan WHERE persediaan.kd_barang=peramalan.kd_barang";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public ResultSet ambil_perObat(String kd_barang) {
        ResultSet r = null;
        String sql = "SELECT SUM(jml_jual) AS jml_jual,kd_barang FROM jual WHERE kd_barang='" + kd_barang + "' GROUP BY YEAR(jual.tgl_jual), MONTH(jual.tgl_jual) ORDER BY tgl_jual";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public ResultSet ambil_tglAkhir(String kd_barang) {
        ResultSet r = null;
        String sql = "select * from jual where kd_barang='" + kd_barang + "' order by tgl_jual desc";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }   
    public ResultSet ambil_periode() {
        ResultSet r = null;
        String sql = "SELECT YEAR(tgl_jual) AS tahun, MONTH(tgl_jual) AS bulan FROM jual GROUP BY YEAR(tgl_jual), MONTH(tgl_jual) ORDER BY tgl_jual";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }   
    public ResultSet ambil_periode(String periode) {
        ResultSet r = null;
        String sql = "SELECT YEAR(tgl_jual) AS tahun, MONTH(tgl_jual) AS bulan, tgl_jual FROM jual WHERE tgl_jual < '" + periode + "' GROUP BY YEAR(tgl_jual), MONTH(tgl_jual) ORDER BY tgl_jual";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }   
    public ResultSet ambil_grupbulan(String kode, String tahun, String bulan) {
        ResultSet r = null;
        String sql = "SELECT SUM(jml_jual) AS jml_jual,kd_barang,tgl_jual FROM jual WHERE kd_barang='" + kode + "' AND YEAR(tgl_jual)='" + tahun + "' AND MONTH(tgl_jual)='" + bulan + "' GROUP BY YEAR(jual.tgl_jual), MONTH(jual.tgl_jual) ORDER BY tgl_jual";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }   
    public int insert(String [] param){
        int i = 0;
        String sql = "INSERT INTO peramalan VALUES(?,?,?,?,?)";    //queri untuk menginsert data pada tabbel admin 
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);  //mengambil data string untuk disimpan pada variabel param index 0
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);
            p.setString(5, param[4]);
            i = p.executeUpdate(); //metod utk mengeksekusi query insert, update, delete
        } catch (SQLException ex) {
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
      public int deleteALL(){
        int i = 0;
        String sql = "truncate peramalan";    //queri untuk menginsert data pada tabbel admin 
        try {
            PreparedStatement p = con.prepareStatement(sql);           
            i = p.executeUpdate(); //metod utk mengeksekusi query insert, update, delete
        } catch (SQLException ex) {
            Logger.getLogger(ModelHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
