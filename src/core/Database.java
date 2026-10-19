package core;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // Tek bir veritabanı bağlantı yöneticisi örneği tutar.
    private static Database instance = null;
    private Connection connection = null;
    private final String DB_URL = "jdbc:mysql://localhost:3306/customermanage";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "";

    // Veritabanına bağlanarak bağlantı nesnesini oluşturur.
    private Database(){

        try {
            // JDBC üzerinden veritabanı bağlantısını açar.
            this.connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);

        }catch (SQLException exception){
            // Bağlantı hatasının ayrıntılarını hata çıktısına yazar.
            exception.printStackTrace();
        }
    }
    
    // Bu yöneticinin sakladığı veritabanı bağlantısını döndürür.
    private Connection getConnection() {
        return connection;
    }

    // Tekil veritabanı yöneticisinin açık bağlantısını döndürür; yoksa yeniden oluşturur.
    public static Connection getInstance() {
        try {
            // Örnek yoksa veya bağlantısı kapalıysa yeni örnek oluşturur.
            if(instance == null|| instance.getConnection().isClosed()){
                instance = new Database();
            }
        } catch (SQLException e) {
            // Bağlantının durumunu kontrol ederken oluşan hatayı bildirir.
            throw new RuntimeException(e);
        }
        // Tekil örneğin veritabanı bağlantısını döndürür.
        return instance.getConnection();
    }


}
