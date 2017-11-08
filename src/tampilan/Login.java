package tampilan;  //Tampilan adalah nama package atau folder dari file Login.java

import com.jtattoo.plaf.texture.TextureLookAndFeel;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import models.ModelUser;

/**
 *
 * @author 6P52
 */
public class Login extends javax.swing.JFrame {

    public Login() {  //Login() adalah nama konstrucktor dari class Login
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Aplikasi");
        setBackground(new java.awt.Color(204, 51, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Apotek Bojong Sehat"));
        jPanel1.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel1.setText("Username :");

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel2.setText("Password :");

        txtUsername.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword)
                    .addComponent(txtUsername)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addContainerGap(19, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        ModelUser mu = new ModelUser(); //membuat objek dg nama mu dari class ModelUser agar bisa menggunakan fungssi2/ method dari class ModelUser
        String user = txtUsername.getText(); //membuat variabel user  bertipe string dg inisialisasi variabel txtIsername
        String pass = new String(txtPassword.getPassword()); //
        String data[] = {user, pass}; //membuat varibel data bertipe string array
        ResultSet r = mu.login(data);
        if (user.equals("") && pass.equals("")) { //logika if else .. jika (benar dan benar) maka akan menjalankan statement yg bener jika salah satu ada yg salah maka menjalankan statemen yg salah
            JOptionPane.showMessageDialog(null, "Mohon Masukan Username & Password"); //Joptionpan utk menampilkan pesan dialog
        } else { //utuk menjalankan statement yg salah
            try {
                if (r.next()) {  //logika if dg kondisi r.next() yaitu jika pada tabel database ada receord yang dituju maka akan menjalankan perintah method next() yaitu mengarahkan kursor maju satu baris dan bernilai true
                    if (r.getString("hak_akses").equals("Admin")) {
                        MenuUtama mn = new MenuUtama();
                        mn.setExtendedState(MAXIMIZED_BOTH); // method agar tampilan frame penuh satu layar
                        mn.lblAkses.setText("Selamat Datang di Halaman ADMIN");
                        mn.jDesktopPane1.removeAll();
                        mn.jDesktopPane1.repaint();
                        mn.jDesktopPane1.add(mn.lblAkses);
                        mn.setVisible(true); //metod agar frame bisa tampil
                        dispose(); // metod utk mengeclose/keluar form login
                    } else {
                        MenuUtama mn = new MenuUtama();
                        mn.setExtendedState(MAXIMIZED_BOTH);
                        mn.lblAkses.setText("Selamat Datang di Halaman USER");
                        mn.jDesktopPane1.removeAll();
                        mn.jDesktopPane1.repaint();
                        mn.jDesktopPane1.add(mn.lblAkses);
                        mn.menuPersediaan.setEnabled(false); //agar menu persediaan tidak aktif atau di disable
                        mn.menuBeli.setEnabled(false);
                        mn.menuHitung.setEnabled(false);
                        mn.menuLapRamal.setEnabled(false);
                        mn.menuUser.setEnabled(false);
                        mn.menuSupplier.setEnabled(false);
                        mn.setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau password salah");
                }
            } catch (SQLException ex) { //try catch utk menangkap kesalahan
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            //sintak untuk menggunakan tema Jtatto
            Properties props = new Properties();
            props.put("logoString", "");
            TextureLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (Exception e) {
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
