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

    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fields){
        for(JTextField field: fields){
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    public static boolean isEmailValid(String mail){
        //info@patika.dev
        //@ olacak , @'ten önce ve sonra bir değer ve @'ten sonra bir nokta olacak
        if(mail == null || mail.trim().isEmpty()) return false;

        if(!mail.contains("@")) return false;

        String[] parts = mail.split("@");
        if(parts.length != 2) return false;

        if(parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) return false;

        if(!parts[1].contains(".")) return false;

        return true;
    }

    public static void optionPaneDialogTR(){
        UIManager.put("OptionPane.okButtonText","Tamam");
    }

    public static void showMsg(String message){
        String msg;
        String title;

        optionPaneDialogTR();
        switch (message){
            case "fill":
                msg = "Lütfen tüm alanları doldurunuz: ";
                title = "HATA!";
                break;
            case "done":
                msg = "İşlem Başarılı";
                title = "Sonuç";
                break;
            case "error":
                msg = "Bir hata oluştu";
                title = "HATA!";
                break;
            default:
                msg = message;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
}
