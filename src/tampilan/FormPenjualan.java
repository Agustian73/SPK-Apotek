package tampilan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ModelJual;
import models.ModelPersediaan;

public class FormPenjualan extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();

    public FormPenjualan() {
        initComponents();
        setLocation((1366 / 2) - (getWidth() / 2), (600 / 2) - (getHeight() / 2));
        tblJual.setModel(model);
        model.addColumn("Kode Jual");
        model.addColumn("Tanggal");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Satuan");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Total");
        loadJual();

        tblBarang.setModel(model2);
        model2.addColumn("Kode Barang");
        model2.addColumn("Nama Barang");
        model2.addColumn("Harga Jual");
        model2.addColumn("Satuan");
        model2.addColumn("Stok");
        loadBarang();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrmBarang = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtJual = new javax.swing.JTextField();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSatuan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnG = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        dateTanggal = new com.toedter.calendar.JDateChooser();
        txtJumlah = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJual = new javax.swing.JTable();

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBarang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FrmBarangLayout = new javax.swing.GroupLayout(FrmBarang.getContentPane());
        FrmBarang.getContentPane().setLayout(FrmBarangLayout);
        FrmBarangLayout.setHorizontalGroup(
            FrmBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrmBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        FrmBarangLayout.setVerticalGroup(
            FrmBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrmBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel1.setText("Kode Jual :");

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel3.setText("Kode Barang :");

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel4.setText("Nama Barang :");

        txtJual.setEditable(false);
        txtJual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtKode.setEditable(false);
        txtKode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNama.setEditable(false);
        txtNama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel6.setText("Satuan :");

        txtSatuan.setEditable(false);
        txtSatuan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel7.setText("Tgl. Jual :");

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel8.setText("Harga :");

        txtHarga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel9.setText("Jumlah :");

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTotalMouseClicked(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnCari.setText("...");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnG.setText("G");
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel10.setText("Total :");

        dateTanggal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateTanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTanggalPropertyChange(evt);
            }
        });

        txtJumlah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txtJual, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addComponent(btnG))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(txtSatuan))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtKode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHarga)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(dateTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtJumlah))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnG))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCari))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblJual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblJual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJualMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblJual);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
    String tanggal;

    private void loadBarang() {
        ModelPersediaan mp = new ModelPersediaan();
        ResultSet r = mp.read();
        model2.getDataVector().removeAllElements();
        try {
            while (r.next()) {
                Object[] obj = new Object[5];
                obj[0] = r.getString("kd_barang");
                obj[1] = r.getString("nm_barang");
                obj[2] = r.getString("hrg_jual");
                obj[3] = r.getString("satuan");
                obj[4] = r.getString("stok");
                model2.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadJual() {
        ModelJual mp = new ModelJual();
        ResultSet r = mp.read();
        model.getDataVector().removeAllElements();
        try {
            while (r.next()) {
                Object[] obj = new Object[8];
                obj[0] = r.getString("kd_jual");
                obj[1] = r.getString("tgl");
                obj[2] = r.getString("kd_barang");
                obj[3] = r.getString("nm_barang");
                obj[4] = r.getString("satuan");
                obj[5] = r.getString("hrg_jual");
                obj[6] = r.getString("jml_jual");
                obj[7] = r.getString("total");
                model.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String autoNumber() {
        ModelJual md = new ModelJual();
        String number = md.generate();
        if (number.equals("")) {
            number = "KJ001";
        } else {
            number = number.substring(2);
            int angka = Integer.parseInt(number);
            angka++;
            if (angka < 10) {
                number = "00" + angka;
            } else if (angka >= 10 && angka < 100) {
                number = "0" + angka;
            } else if (angka >= 100 && angka < 1000) {
                number = "" + angka;
            } else {
                number = String.valueOf(angka);
            }
            if (number.length() > 5) {
                number = number.substring(number.length() - 5, number.length());
            }
            number = "KJ" + number;
        }
        return number;
    }

    private void txtTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTotalMouseClicked
        int hrg = Integer.parseInt(txtHarga.getText());
        int jml = Integer.parseInt(txtJumlah.getText());
        int tot = hrg * jml;
        txtTotal.setText(String.valueOf(tot));
    }//GEN-LAST:event_txtTotalMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        ModelJual mu = new ModelJual();
        if (txtKode.getText().equals("") ||txtJual.getText().equals("") ||txtJumlah.getText().equals("") || txtNama.getText().equals("") || txtSatuan.getText().equals("") || txtHarga.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon inputkan semua data");
        } else {
        String b = txtKode.getText();
        int jml = Integer.valueOf(txtJumlah.getText());
        String periode = Format.format(Calendar.getInstance().getTime());
        ResultSet c = mu.ambil(b);
        ResultSet valid = mu.validasi(b, periode);
        try {
            c.next();
            int stok = c.getInt("stok");
            int hasil = stok - jml;
            if (valid.next()) {
                JOptionPane.showMessageDialog(null, "Nama obat dengan kode "+b+ " pada hari ini sudah diinputkan");
            }else{
                if (hasil >= 0) {
                    if (txtJual.getText().equals("") && txtKode.getText().equals("") && txtHarga.getText().equals("") && txtHarga.getText().equals("") && txtSatuan.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Mohon inputkan semua data");
                    } else {
                        String[] data = {txtJual.getText(), txtKode.getText(), txtHarga.getText(), txtJumlah.getText(), txtTotal.getText(), tanggal

                        };
                        if (mu.insert(data) > 0) {
                            JOptionPane.showMessageDialog(null, "Data tersimpan");
                             loadBarang();
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal");
                        }
                        loadJual();                       
                        dateTanggal.setDate(null);
                        txtJual.setText("");
                        txtKode.setText("");
                        txtNama.setText("");
                        txtSatuan.setText("");
                        txtHarga.setText("");
                        txtJumlah.setText("");
                        txtTotal.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah pemakaian melebihi stok yang tersedia");
                    dateTanggal.setDate(null);
                    txtJual.setText("");
                    txtKode.setText("");
                    txtNama.setText("");
                    txtSatuan.setText("");
                    txtHarga.setText("");
                    txtJumlah.setText("");
                    txtTotal.setText("");
                }  
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        ModelJual mu = new ModelJual();
        String[] data = {txtKode.getText(), txtHarga.getText(), txtJumlah.getText(), txtTotal.getText(), tanggal, txtJual.getText()};
        if (mu.update(data) > 0) {
            JOptionPane.showMessageDialog(null, "Data terupdate");
        } else {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
        loadJual();
        dateTanggal.setDate(null);
        txtJual.setText("");
        txtKode.setText("");
        txtNama.setText("");
        txtSatuan.setText("");
        txtHarga.setText("");
        txtJumlah.setText("");
        txtTotal.setText("");
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        ModelJual mu = new ModelJual();
        String[] data = {txtJual.getText()};
        if (JOptionPane.showConfirmDialog(this, "Yakin menghapus data?", "Peringatan", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            mu.delete(data);
            JOptionPane.showMessageDialog(null, "Data terhapus");
        } else {
            JOptionPane.showMessageDialog(null, "Batal Menghapus");
        }
        loadJual();
        dateTanggal.setDate(null);
        txtJual.setText("");
        txtKode.setText("");
        txtNama.setText("");
        txtSatuan.setText("");
        txtHarga.setText("");
        txtJumlah.setText("");
        txtTotal.setText("");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        FrmBarang.setBounds(300, 300, 500, 350);
        FrmBarang.setTitle("Data Barang");
        FrmBarang.setVisible(true);
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGActionPerformed
        txtJual.setText(autoNumber());
    }//GEN-LAST:event_btnGActionPerformed

    private void tblJualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJualMouseClicked
        try {
            int row = tblJual.getSelectedRow();
            String kd = (String) tblJual.getValueAt(row, 0);
            ModelJual m = new ModelJual();
            ResultSet r = m.pilih(kd);
            r.next();
            txtJual.setText(tblJual.getValueAt(row, 0).toString());
            txtKode.setText(tblJual.getValueAt(row, 2).toString());
            txtNama.setText(tblJual.getValueAt(row, 3).toString());
            txtSatuan.setText(tblJual.getValueAt(row, 4).toString());
            String harga = tblJual.getValueAt(row, 5).toString().toString().replace(",", "");
            txtHarga.setText(harga);
            txtJumlah.setText(tblJual.getValueAt(row, 6).toString());
            String total = tblJual.getValueAt(row, 7).toString().toString().replace(",", "");
            txtTotal.setText(total);
            java.util.Date dateValue = null;
            try {
                dateValue = Format.parse(r.getString("tgl_jual"));
            } catch (ParseException ex) {
                Logger.getLogger(FormPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
            dateTanggal.setDate(dateValue);
        } catch (SQLException ex) {
            Logger.getLogger(FormPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblJualMouseClicked

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        int row = tblBarang.getSelectedRow();
        txtKode.setText(tblBarang.getValueAt(row, 0).toString());
        txtNama.setText(tblBarang.getValueAt(row, 1).toString());
        txtHarga.setText(tblBarang.getValueAt(row, 2).toString().replace(",", ""));
        txtSatuan.setText(tblBarang.getValueAt(row, 3).toString());
        FrmBarang.dispose();
    }//GEN-LAST:event_tblBarangMouseClicked

    private void dateTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTanggalPropertyChange
        if (dateTanggal.getDate() != null) {
            tanggal = Format.format(dateTanggal.getDate());
        }
    }//GEN-LAST:event_dateTanggalPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog FrmBarang;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnG;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private com.toedter.calendar.JDateChooser dateTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTable tblJual;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJual;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtSatuan;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
