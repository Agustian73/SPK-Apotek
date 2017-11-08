
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
public class ModelUser extends Koneksi{
    //fungsi utk memilih/menampilkan data pada tabel adamin
    public ResultSet login(String [] param){  //metod login dg parameter variabel param bertipe string array
        ResultSet r = null;
        String sql = "SELECT * FROM admin WHERE username=? AND password=?";   //queri untuk menampilkan data pada tabbel admin    
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);           
            r = p.executeQuery();         //metod utk mengeksekusi query select  
        } catch (SQLException ex) {
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public ResultSet read(){
        ResultSet r = null;
        String sql = "SELECT * FROM admin";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public int insert(String [] param){
        int i = 0;
        String sql = "INSERT INTO admin VALUES(?,?,?,?)";    //queri untuk menginsert data pada tabbel admin 
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);  //mengambil data string untuk disimpan pada variabel param index 0
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);
            i = p.executeUpdate(); //metod utk mengeksekusi query insert, update, delete
        } catch (SQLException ex) {
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int update(String [] param){
        int i = 0;
        String sql = "UPDATE admin SET username=?, password=?, hak_akses=? WHERE id_admin=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int delete(String [] param){
        int i = 0;
        String sql = "DELETE FROM admin WHERE id_admin=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
