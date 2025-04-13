package business.service;

import business.dao.LoginDao;
import business.model.Login;

public class LoginService {
    private LoginDao loginDao;

    public LoginService() {
        this.loginDao = new LoginDao();
    }

    public Login login(String username, String password) {
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            System.out.println("ten dang nhap va mat khau khong duoc de trong");
            return null;
        }
        Login login = loginDao.checkLogin(username, password);
        if (login == null) {
            System.out.println("ten dang nhap hoac mk khong hop le");
        }
        return login;
    }
}