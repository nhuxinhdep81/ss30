package presentation;

import business.model.Login;
import business.service.LoginService;

import java.util.Scanner;

public class LoginUI {
    private LoginService loginService;
    private Scanner scanner;

    public LoginUI() {
        this.loginService = new LoginService();
        this.scanner = new Scanner(System.in);
    }

    public Login displayLogin() {
        System.out.println("===== LOGIN =====");
        System.out.print("Ten dang nhap: ");
        String username = scanner.nextLine();
        System.out.print("Mat khau: ");
        String password = scanner.nextLine();

        Login login = loginService.login(username, password);
        if (login != null) {
            System.out.println("Dang nhap thanh cong!!! " + login.getRole() + " " + login.getUsername());
        } else {
            System.out.println("Dang nhap that bai!");
        }
        return login;
    }

    public void displayLogout() {
        System.out.println("Dang xuat thanh cong!!!");
    }
}