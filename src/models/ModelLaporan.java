
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
public class ModelLaporan extends Koneksi{
    
    public ResultSet tanggal(){
        ResultSet i = null;
        String sql = "SELECT DATE_FORMAT(jual.tgl_jual,'%m-%Y') AS tgl FROM jual GROUP BY MONTH(tgl_jual), YEAR(tgl_jual)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            i = p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ModelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  i;
    }    
}
