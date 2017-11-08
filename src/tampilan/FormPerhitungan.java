package tampilan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.ModelHitung;

public class FormPerhitungan extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();

    public FormPerhitungan() {
        initComponents();
        setLocation((1366 / 2) - (getWidth() / 2), (600 / 2) - (getHeight() / 2));
        tblHitung.setModel(model);
        model.addColumn("Nomer");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Hasil Peramalan");
        //txtPeriode.setText(tanggal);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnProses = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPeriode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHitung = new javax.swing.JTable();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnProses.setText("PROSES PERAMALAN");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel4.setText("Periode Peramalan :");

        txtPeriode.setEditable(false);
        txtPeriode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProses)
                .addGap(384, 384, 384)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProses)
                    .addComponent(txtPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        tblHitung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblHitung);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //SimpleDateFormat now = new SimpleDateFormat("dd-MM-yyyy");
    //String tanggal = now.format(Calendar.getInstance().getTime());
    private void loadAnalisa2() {
        try {
            ModelHitung md = new ModelHitung();
            ArrayList jml_jual = new ArrayList();
            ResultSet r = md.ambil_kode();
            md.deleteALL();
            tgl_max();
            int tot_x = 0;
            int index = 1;
            int Y = 0;
            int tot_y = 0;
            double Y2 = 0;
            double X2 = 0;
            int XY = 0;
            int n = 0;
            int X = 1;
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = df.format(Calendar.getInstance().getTime());
            double hasil, b, a;           
            while (r.next()) {
                ResultSet r1 = md.ambil_periode(tanggal);
                while (r1.next()) {
                    ResultSet r2 = md.ambil_grupbulan(r.getString("kd_barang"), r1.getString("tahun"), r1.getString("bulan"));
                    if (r2.next()) {
                        jml_jual.add(r2.getString("jml_jual"));
                    } else {
                        jml_jual.add("0");
                    }
                    tot_x = tot_x + X;
                    Y = Integer.valueOf(jml_jual.get(index - 1).toString());
                    tot_y += Integer.valueOf(jml_jual.get(index - 1).toString());
                    X2 += Math.pow(X, 2);
                    Y2 += Math.pow(Y, 2);
                    XY += X * Y;
                    index++;
                    X++;                   
                }
                n = X - 1;
                b = (n * XY - tot_x * tot_y) / ((n * X2) - (Math.pow(tot_x, 2)));
                a = (tot_y - b * tot_x) / n;
                hasil = a + b * (n + 1);
                String hsl = String.valueOf(hasil);
                String[] data = {null, r.getString("kd_barang"), tanggal, txtPeriode.getText(), hsl};
                md.insert(data);
                X = 1;
                tot_y = 0;
                tot_x = 0;
                X2 = 0;
                Y2 = 0;
                XY = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormPerhitungan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        //loadAnalisa();
        loadAnalisa2();
        loadData();
    }//GEN-LAST:event_btnProsesActionPerformed

    private void tgl_max() {
        try {
            ModelHitung mh = new ModelHitung();
            String tgl = null;
            ResultSet r = mh.tgl_max();
            r.next();
            Calendar tanggalnya = Calendar.getInstance();
           tanggalnya.setTime(r.getDate("tgl_jual"));
           tanggalnya.add(Calendar.MONTH, 1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
            Date date = tanggalnya.getTime();
            tgl = dateFormat.format(date);
            String[] ambil = tgl.split("-");
            String periode;
            if (ambil[0].equals("01")) {
                periode = "Januari";
            } else if (ambil[0].equals("02")) {
                periode = "Februari";
            } else if (ambil[0].equals("03")) {
                periode = "Maret";
            } else if (ambil[0].equals("04")) {
                periode = "April";
            } else if (ambil[0].equals("05")) {
                periode = "Mei";
            } else if (ambil[0].equals("06")) {
                periode = "Juni";
            } else if (ambil[0].equals("07")) {
                periode = "Juli";
            } else if (ambil[0].equals("08")) {
                periode = "Agustus";
            } else if (ambil[0].equals("09")) {
                periode = "September";
            } else if (ambil[0].equals("10")) {
                periode = "Oktober";
            } else if (ambil[0].equals("11")) {
                periode = "Nopember";
            } else{
                periode = "Desember";
            }
            txtPeriode.setText(periode+" "+ambil[1]);
        } catch (SQLException ex) {
            Logger.getLogger(FormPerhitungan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadData() {
        ModelHitung mh = new ModelHitung();
        ResultSet r = mh.tampil_data();
        model.getDataVector().removeAllElements();
        try {
            while (r.next()) {
                Object obj[] = new Object[4];
                obj[1] = r.getString("kd_barang");
                obj[2] = r.getString("nm_barang");
                obj[3] = r.getString("hasil");
                model.addRow(obj);
                noTable();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormPerhitungan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void noTable() {
        int baris = model.getRowCount();
        for (int a = 0; a < baris; a++) {
            String nomor = String.valueOf(a + 1);
            model.setValueAt(nomor, a, 0);
        }
    }

    private void loadAnalisa() {
        try {
            ModelHitung md = new ModelHitung();
            ResultSet r1 = md.ambil_kode(); //select * group kode
            md.deleteALL();
            while (r1.next()) {
                String tgl = null;
                int x = 0;
                int X = 1;
                int y = 0;
                int Y = 0;
                double Y2 = 0;
                double X2 = 0;
                int XY = 0;
                int n = 0;
                double hasil, b, a;
                ResultSet r2 = md.ambil_perObat(r1.getString("kd_barang"));
                while (r2.next()) {
                    x = x + X;
                    y = r2.getInt("jml_jual");
                    Y += r2.getInt("jml_jual");
                    X2 += Math.pow(X, 2);
                    Y2 += Math.pow(y, 2);
                    XY += X * y;
                    X++;
                }
                ResultSet r3 = md.ambil_tglAkhir(r1.getString("kd_barang"));
                r3.next();
                n = X - 1;
                Calendar tanggalnya = Calendar.getInstance();
                tanggalnya.setTime(r3.getDate("tgl_jual"));
                tanggalnya.add(Calendar.DATE, 30);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = tanggalnya.getTime();
                tgl = dateFormat.format(date);

                b = (n * XY - x * Y) / ((n * X2) - (Math.pow(x, 2)));
                a = (Y - b * x) / n;
                hasil = a + b * (n + 1);
                String hsl = String.valueOf(hasil);
                System.out.println(hasil);
                String[] data = {null, r1.getString("kd_barang"), tgl, hsl};
                md.insert(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormPerhitungan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProses;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHitung;
    private javax.swing.JTextField txtPeriode;
    // End of variables declaration//GEN-END:variables

}
