

package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Koneksi;

/**
 *
 * @author 6P52
 */
public class ModelPersediaan extends Koneksi{
    public ResultSet read(){
        ResultSet r = null;
        String sql = "SELECT kd_barang, nm_barang, format(hrg_jual,0) AS hrg_jual, satuan, stok FROM persediaan";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersediaan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public int insert(String [] param){
        int i = 0;
        String sql = "INSERT INTO persediaan VALUES(?,?,?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);
            p.setString(5, param[4]);           
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersediaan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int update(String [] param){
        int i = 0;
        String sql = "UPDATE persediaan SET nm_barang=?, hrg_jual=?, satuan=?, stok=? WHERE kd_barang=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);
            p.setString(5, param[4]);
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersediaan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int delete(String [] param){
        int i = 0;
        //String sql = "DELETE persediaan, jual, beli, trans_beli FROM persediaan LEFT JOIN join ON persediaan.kd_barang = jual.kd_barang LEFT JOIN persediaan ON persediaan.kd_barang = beli.kd_barang LEFT JOIN beli ON beli.no_faktur = trans_beli.no_faktur WHERE persediaan.kd_barang=?";
        String sql = "DELETE persediaan, jual, beli FROM persediaan, jual, beli WHERE persediaan.kd_barang=jual.kd_barang AND persediaan.kd_barang=beli.kd_barang AND persediaan.kd_barang=?";
        //String sql = "DELETE persediaan, jual, beli FROM persediaan, jual, beli WHERE persediaan.kd_barang=jual.kd_barang AND persediaan.kd_barang=beli.kd_barang AND persediaan.kd_barang=?";
        //DELETE a.*, b.*, c.* FROM persediaan a, jual b, beli c WHERE a.kd_barang =? AND  b.kd_barang=? AND  c.kd_barang=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersediaan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int delete2(String [] param){
        int i = 0;
        //String sql = "DELETE persediaan, jual, beli, trans_beli FROM persediaan LEFT JOIN join ON persediaan.kd_barang = jual.kd_barang LEFT JOIN persediaan ON persediaan.kd_barang = beli.kd_barang LEFT JOIN beli ON beli.no_faktur = trans_beli.no_faktur WHERE persediaan.kd_barang=?";
        String sql = "DELETE FROM persediaan WHERE kd_barang=?";
        //String sql = "DELETE persediaan, jual, beli FROM persediaan, jual, beli WHERE persediaan.kd_barang=jual.kd_barang AND persediaan.kd_barang=beli.kd_barang AND persediaan.kd_barang=?";
        //DELETE a.*, b.*, c.* FROM persediaan a, jual b, beli c WHERE a.kd_barang =? AND  b.kd_barang=? AND  c.kd_barang=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersediaan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
