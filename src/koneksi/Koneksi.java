/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6P52
 */
public class Koneksi {
    //membuat variabel
    public Connection con;
    Statement st;
    public Koneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //meload/ memanggil driver mysql
            String url ="jdbc:mysql://localhost/spk_apotek?user=root&password=";  //nama dari database yang akan di keoneksikan
            con = DriverManager.getConnection(url);  //metod utk mengkoneksikan dg database
            con.createStatement();
        }catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}
