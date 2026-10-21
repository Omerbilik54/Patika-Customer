package view;

import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;


public class DashboardUI extends JFrame {

    private JPanel container;
    private User user;

    public DashboardUI(User user){
        this.user = user ;
        if(user  == null){
            Helper.showMsg("error");
            dispose();
        }
        this.add(container);
        this.setTitle("Müşteri Yönetim Sistemi");
        this.setSize(1000,500);
        // Ekran çözünürlüğünü ve pencere boyutunu kullanarak yatay konumu hesaplar.
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        // Dikey konumu ekran yüksekliği ile pencere genişliğinin farkından hesaplar.
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().width) / 2;
        // Pencereyi hesaplanan konuma taşır.
        this.setLocation(x, y);
        // Pencereyi görünür yapar.
        this.setVisible(true);


        System.out.println(this.user.toString());

    }
}
