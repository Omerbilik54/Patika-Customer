package core;

import javax.swing.*;

public class Helper {
    // Uygulama için Nimbus görünüm temasını etkinleştirir.
    public static void setTheme(){
        // Sistemde yüklü görünüm temalarını listeler.
        for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            // Tema adını kontrol eder.
            if(info.getName().equals("Nimbus")){
                try {
                    // Nimbus temasını Swing bileşenlerine uygular.
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException |
                         InstantiationException e) {
                    // Tema yüklenemezse hatayı çalışma zamanı hatası olarak bildirir.
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    // Metin alanının boş olup olmadığını kontrol eder.
    public static boolean isFieldEmpty(JTextField field){
        // Metni alır, kenar boşluklarını temizler ve boş olup olmadığını sınar.
        return field.getText().trim().isEmpty();
    }

    // Verilen metin alanlarından en az biri boşsa true döndürür.
    public static boolean isFieldListEmpty(JTextField[] fields){
        for(JTextField field: fields){
            // Her alanı boşluk kontrolü için yardımcı metoda gönderir.
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    // E-posta adresinin temel biçim kurallarına uyup uymadığını kontrol eder.
    public static boolean isEmailValid(String mail){
        // Null veya yalnızca boşluk içeren değerleri geçersiz sayar.
        if(mail == null || mail.trim().isEmpty()) return false;

        // Adreste @ karakteri bulunmasını zorunlu tutar.
        if(!mail.contains("@")) return false;

        // Adresi @ karakterine göre iki parçaya ayırır.
        String[] parts = mail.split("@");
        if(parts.length != 2) return false;

        // @ işaretinin iki tarafının da dolu olmasını kontrol eder.
        if(parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) return false;

        // @ işaretinden sonraki bölümde nokta bulunmasını zorunlu tutar.
        if(!parts[1].contains(".")) return false;

        return true;
    }

    // Swing iletişim kutularındaki onay düğmesinin metnini Türkçeleştirir.
    public static void optionPaneDialogTR(){
        // Onay düğmesinin görünen metnini "Tamam" olarak ayarlar.
        UIManager.put("OptionPane.okButtonText","Tamam");
    }

    // Mesaj türüne göre Türkçe başlık ve içerikle bilgi penceresi gösterir.
    public static void showMsg(String message){
        String msg;
        String title;

        // İletişim kutusunun düğme metnini Türkçeleştirir.
        optionPaneDialogTR();
        title = switch (message) {
            case "fill" -> {
                msg = "Lütfen tüm alanları doldurunuz: ";
                yield "HATA!";
            }
            case "done" -> {
                msg = "İşlem Başarılı";
                yield "Sonuç";
            }
            case "error" -> {
                msg = "Bir hata oluştu";
                yield "HATA!";
            }
            default -> {
                msg = message;
                yield "Mesaj";
            }
        };
        // Hazırlanan mesajı bir iletişim penceresinde gösterir.
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
}
