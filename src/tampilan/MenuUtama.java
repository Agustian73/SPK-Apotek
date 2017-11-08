package tampilan;

import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.UIManager;


public class MenuUtama extends javax.swing.JFrame {

        
    public MenuUtama() {
        initComponents();
       
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new ClGambarDesktop();
        lblAkses = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSupplier = new javax.swing.JMenuItem();
        menuPersediaan = new javax.swing.JMenuItem();
        menuBeli = new javax.swing.JMenuItem();
        menuJual = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuHitung = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuLapJual = new javax.swing.JMenuItem();
        menuLapRamal = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuUser = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEM PENDUKUNG KEPUTUSAN PERAMALAN PENJUALAN OBAT PADA APOTEK BOJONG SEHAT");

        jDesktopPane1.setOpaque(false);

        lblAkses.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAkses.setText("jLabel1");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(731, Short.MAX_VALUE)
                .addComponent(lblAkses)
                .addGap(51, 51, 51))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAkses)
                .addContainerGap(430, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(lblAkses, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("Master");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu1.add(jSeparator1);

        menuSupplier.setText("Data Supplier");
        menuSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSupplierActionPerformed(evt);
            }
        });
        jMenu1.add(menuSupplier);

        menuPersediaan.setText("Persediaan Obat");
        menuPersediaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPersediaanActionPerformed(evt);
            }
        });
        jMenu1.add(menuPersediaan);

        menuBeli.setText("Trans. Pembelian");
        menuBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBeliActionPerformed(evt);
            }
        });
        jMenu1.add(menuBeli);

        menuJual.setText("Data Penjualan");
        menuJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuJualActionPerformed(evt);
            }
        });
        jMenu1.add(menuJual);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Peramalan");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu3.add(jSeparator3);

        menuHitung.setText("Proses Hitung");
        menuHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHitungActionPerformed(evt);
            }
        });
        jMenu3.add(menuHitung);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Laporan");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu4.add(jSeparator4);

        menuLapJual.setText("Lap. Penjualan");
        menuLapJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLapJualActionPerformed(evt);
            }
        });
        jMenu4.add(menuLapJual);

        menuLapRamal.setText("Lap. Peramalan");
        menuLapRamal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLapRamalActionPerformed(evt);
            }
        });
        jMenu4.add(menuLapRamal);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Setting User");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu5.add(jSeparator5);

        menuUser.setText("Kelola User");
        menuUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUserActionPerformed(evt);
            }
        });
        jMenu5.add(menuUser);

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        jMenu5.add(menuLogout);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        setBounds(0, 0, 861, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void menuPersediaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersediaanActionPerformed
        Persediaan mb = new Persediaan();
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        mb.setTitle("Persediaan Obat");
        mb.setVisible(true);
        jDesktopPane1.add(mb);
    }//GEN-LAST:event_menuPersediaanActionPerformed

    private void menuBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBeliActionPerformed
        FormPembelian pb = new FormPembelian();
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        pb.setTitle("Trans. Pembelian");
        pb.setVisible(true);
        jDesktopPane1.add(pb);
    }//GEN-LAST:event_menuBeliActionPerformed

    private void menuJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuJualActionPerformed
        FormPenjualan pj = new FormPenjualan();
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        pj.setTitle("Data Penjualan");
        pj.setVisible(true);
        jDesktopPane1.add(pj);
    }//GEN-LAST:event_menuJualActionPerformed

    private void menuHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHitungActionPerformed
        FormPerhitungan ph = new FormPerhitungan();
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ph.setTitle("Proses Hitung");
        ph.setVisible(true);
        jDesktopPane1.add(ph);
    }//GEN-LAST:event_menuHitungActionPerformed

    private void menuLapJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLapJualActionPerformed
        LapPenjualan ph = new LapPenjualan();
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ph.setTitle("Laporan Penjualan");
        ph.setVisible(true);
        jDesktopPane1.add(ph);
    }//GEN-LAST:event_menuLapJualActionPerformed

    private void menuLapRamalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLapRamalActionPerformed
        LapPeramalan ph = new LapPeramalan();
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ph.setTitle("Laporan Peramalan");
        ph.setVisible(true);
        jDesktopPane1.add(ph);
    }//GEN-LAST:event_menuLapRamalActionPerformed

    private void menuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUserActionPerformed
        KelolaUser ph = new KelolaUser();
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ph.setTitle("Kelola User");
        ph.setVisible(true);
        jDesktopPane1.add(ph);
    }//GEN-LAST:event_menuUserActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSupplierActionPerformed
        Supplier ph = new Supplier();
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ph.setTitle("Data Supplier");
        ph.setVisible(true);
        jDesktopPane1.add(ph);
    }//GEN-LAST:event_menuSupplierActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try{
	UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
	}catch(Exception e){
	}
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {               
                MenuUtama mn = new MenuUtama();
                mn.setExtendedState(MAXIMIZED_BOTH);
                mn.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    public javax.swing.JLabel lblAkses;
    public javax.swing.JMenuItem menuBeli;
    public javax.swing.JMenuItem menuHitung;
    private javax.swing.JMenuItem menuJual;
    private javax.swing.JMenuItem menuLapJual;
    public javax.swing.JMenuItem menuLapRamal;
    private javax.swing.JMenuItem menuLogout;
    public javax.swing.JMenuItem menuPersediaan;
    public javax.swing.JMenuItem menuSupplier;
    public javax.swing.JMenuItem menuUser;
    // End of variables declaration//GEN-END:variables
}
