import business.model.Login;
import presentation.DepartmentUI;
import presentation.EmployeeUI;
import presentation.LoginUI;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginUI loginUI = new LoginUI();
        DepartmentUI departmentUI = new DepartmentUI();
        EmployeeUI employeeUI = new EmployeeUI();

        Login login = loginUI.displayLogin();
        if (login == null) {
            System.out.println("Ket thuc chuong trinh do dang nhap that bai.");
            return;
        }
        while (true) {
            System.out.println("\n===== MENU CHINH =====");
            System.out.println("1. Quan ly phong ban");
            System.out.println("2. Quan ly nhan vien");
            System.out.println("0. Dang xuat va thoat");
            System.out.print("Chon mot tuy chon: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    departmentUI.showMenu();
                    break;
                case 2:
                    employeeUI.showMenu();
                    break;
                case 0:
                    loginUI.displayLogout();
                    System.out.println("Ket thuc chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
