package business;

import core.Helper;
import dao.UserDao;
import entity.User;

import java.sql.SQLException;

public class UserController {
    private final UserDao userDao = new UserDao();

    public User findByLogin(String mail , String password) throws SQLException {
        if(!Helper.isEmailValid(mail)) return null;
        return this.userDao.findByLogin(mail, password);
    }
}
