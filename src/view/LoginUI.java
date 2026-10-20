package view;

import business.UserController;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginUI extends JFrame {
    private JPanel container;
    private JPanel pnl_top;
    private JLabel lbl_title;
    private JPanel pnl_bottom;
    private JTextField fld_mail;
    private JButton btn_login;
    private JLabel lbl_mail;
    private JLabel lbl_password;
    private JPasswordField fld_password;
    private UserController userController ;

    // Giriş penceresini kurar ve ekranda ortalayarak gösterir.
    public LoginUI() {
        this.userController = new UserController();
        // Formun ana panelini pencereye ekler.
        this.add(container);
        // Pencerenin başlığını belirler.
        this.setTitle("Müşteri Yönetim Sistemi");
        // Pencerenin genişlik ve yüksekliğini ayarlar.
        this.setSize(400, 400);

        // Ekran çözünürlüğünü ve pencere boyutunu kullanarak yatay konumu hesaplar.
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        // Dikey konumu ekran yüksekliği ile pencere genişliğinin farkından hesaplar.
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().width) / 2;
        // Pencereyi hesaplanan konuma taşır.
        this.setLocation(x, y);
        // Pencereyi görünür yapar.
        this.setVisible(true);
        // Giriş düğmesine tıklama dinleyicisi ekler; mevcut işlem gövdesi boştur.
        this.btn_login.addActionListener(e -> {
            JTextField[] checkList = {this.fld_mail, this.fld_password};
            if(Helper.isFieldListEmpty(checkList)){
                Helper.showMsg("fill");
            }else if(!Helper.isEmailValid(this.fld_mail.getText())){
            Helper.showMsg("Geçerli bir e-posta adresi giriniz.");
            }else{
                User user = null;
                try {
                    user = this.userController.findByLogin(this.fld_mail.getText(), this.fld_password.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if(user == null){
                    Helper.showMsg("Girdiğiniz bilgilerle eşleşen bir kullanıcı bulunamadı.");
                }else{
                    this.dispose();
                    DashboardUI dashboardUI = new DashboardUI(user);
                }
            }
        });
    }
}
