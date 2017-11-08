package tampilan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Koneksi;
import models.ModelLaporan;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author 6P52
 */
public class LapPenjualan extends javax.swing.JInternalFrame {

    public LapPenjualan() {
        initComponents();
        tanggal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbbTgl = new javax.swing.JComboBox();
        txtTampil = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel2.setText("Tanggal :");

        txtTampil.setText("Tampilkan");
        txtTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTampilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTampil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTampil))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTampilActionPerformed
        String[] tg = cbbTgl.getSelectedItem().toString().split("-");
        try {            
            Koneksi sr = new Koneksi();                  
            JasperReport jasperReport = JasperCompileManager.compileReport("laporan/lap_penjualan.jrxml");
            HashMap<String, Object> p = new HashMap<String, Object>(); //semacam array            
            p.put("tgl_jual", tg[1]);
            p.put("tgl_jual1", tg[0]);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, p, sr.con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(LapPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        //SELECT total FROM penjualan WHERE YEAR(tanggal)=2017 AND MONTH(tanggal)=04
        //SELECT persediaan.kd_barang, persediaan.nm_barang, penjualan.tanggal, penjualan_det.harga, penjualan_det.jml, penjualan_det.total FROM persediaan, penjualan, penjualan_det WHERE persediaan.kd_barang=penjualan_det.kd_barang AND penjualan_det.kd_jual=penjualan.kd_jual AND YEAR(penjualan.tanggal)=2017 AND MONTH(penjualan.tanggal)=04
    }//GEN-LAST:event_txtTampilActionPerformed

    public void tanggal() {
        ModelLaporan ml = new ModelLaporan();
        ResultSet r = ml.tanggal();
        try {
            while (r.next()) {
                cbbTgl.addItem(r.getString("tgl"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LapPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbbTgl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton txtTampil;
    // End of variables declaration//GEN-END:variables
}
