package core;

import javax.swing.*;

public class Helper {
    //Uygulamaya daha profesyonel bir görünüm kazandırmak için Java'nın hazır Nimbus temasının projeye entegre edilmesi.
    public static void setTheme(){
        for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if(info.getName().equals("Nimbus")){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException |
                         InstantiationException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }
}
