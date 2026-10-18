import core.Database;
import core.Helper;
import view.LoginUI;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        Helper.setTheme();
        //Connection connect1 = Database.getInstance();
        LoginUI loginUI = new LoginUI();
    }
}





