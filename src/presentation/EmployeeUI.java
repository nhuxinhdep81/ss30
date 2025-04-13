package presentation;

import business.model.Employee;
import business.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeUI {
    private EmployeeService employeeService;
    private Scanner scanner;

    public EmployeeUI() {
        this.employeeService = new EmployeeService();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== QUAN LY NHAN VIEN =====");
            System.out.println("1. Danh sach nhan vien co phan trang");
            System.out.println("2. Them nhan vien");
            System.out.println("3. Cap nhat nhan vien");
            System.out.println("4. Xoa nhan vien");
            System.out.println("5. Tim kiem nhan vien theo ten");
            System.out.println("6. Tim kiem nhan vien theo khoang tuoi");
            System.out.println("7. Sap xep nhan vien theo luong giam dan");
            System.out.println("8. Sap xep ten nhan vien tang dan");
            System.out.println("9. Thong ke nhan vien");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Chon chuc nang: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayEmployeesByPage();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    searchEmployeeByName();
                    break;
                case 6:
                    searchEmployeeByAgeRange();
                    break;
                case 7:
                    sortEmployeesBySalaryDesc();
                    break;
                case 8:
                    sortEmployeesByNameAsc();
                    break;
                case 9:
                    showStatisticsMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private void displayEmployeesByPage() {
        System.out.print("Nhap so trang: ");
        int pageNumber = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = employeeService.getEmployeesByPage(pageNumber);
        if (employees != null && !employees.isEmpty()) {
            System.out.println("===== Danh sach nhan vien (Trang " + pageNumber + ") =====");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Khong co nhan vien nao o trang nay!");
        }
    }

    private void addEmployee() {
        System.out.print("Nhap ma nhan vien (E + 4 ky tu): ");
        String empId = scanner.nextLine();
        System.out.print("Nhap ten nhan vien (15-150 ky tu): ");
        String empName = scanner.nextLine();
        System.out.print("Nhap email: ");
        String empEmail = scanner.nextLine();
        System.out.print("Nhap so dien thoai (so di dong VN): ");
        String empPhone = scanner.nextLine();
        System.out.print("Nhap gioi tinh (MALE/FEMALE/OTHER): ");
        String empGender = scanner.nextLine().toUpperCase();
        System.out.print("Nhap bac luong (> 0): ");
        int empGrade = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap luong (> 0): ");
        double empSalary = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
        String empBirthStr = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        String empAddress = scanner.nextLine();
        System.out.print("Nhap trang thai (ACTIVE/INACTIVE/ONLEAVE/POLICYLEAVE): ");
        String empStatus = scanner.nextLine().toUpperCase();
        System.out.print("Nhap ma phong ban: ");
        int deptId = Integer.parseInt(scanner.nextLine());

        employeeService.addEmployee(empId, empName, empEmail, empPhone, empGender, empGrade, empSalary,
                empBirthStr, empAddress, empStatus, deptId);
    }

    private void updateEmployee() {
        System.out.print("Nhap ma nhan vien can cap nhat: ");
        String empId = scanner.nextLine();
        System.out.print("Nhap ten moi (15-150 ky tu): ");
        String empName = scanner.nextLine();
        System.out.print("Nhap email moi: ");
        String empEmail = scanner.nextLine();
        System.out.print("Nhap so dien thoai moi: ");
        String empPhone = scanner.nextLine();
        System.out.print("Nhap gioi tinh moi (MALE/FEMALE/OTHER): ");
        String empGender = scanner.nextLine().toUpperCase();
        System.out.print("Nhap bac luong moi (> 0): ");
        int empGrade = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap luong moi (> 0): ");
        double empSalary = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap ngay sinh moi (dd/MM/yyyy): ");
        String empBirthStr = scanner.nextLine();
        System.out.print("Nhap dia chi moi: ");
        String empAddress = scanner.nextLine();
        System.out.print("Nhap trang thai moi (ACTIVE/INACTIVE/ONLEAVE/POLICYLEAVE): ");
        String empStatus = scanner.nextLine().toUpperCase();
        System.out.print("Nhap ma phong ban moi: ");
        int deptId = Integer.parseInt(scanner.nextLine());

        employeeService.updateEmployee(empId, empName, empEmail, empPhone, empGender, empGrade, empSalary,
                empBirthStr, empAddress, empStatus, deptId);
    }

    private void deleteEmployee() {
        System.out.print("Nhap ma nhan vien can xoa: ");
        String empId = scanner.nextLine();
        employeeService.deleteEmployee(empId);
    }

    private void searchEmployeeByName() {
        System.out.print("Nhap ten nhan vien can tim: ");
        String empName = scanner.nextLine();
        List<Employee> employees = employeeService.searchEmployeeByName(empName);
        if (employees != null && !employees.isEmpty()) {
            System.out.println("===== Ket qua tim kiem =====");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Khong tim thay nhan vien!");
        }
    }

    private void searchEmployeeByAgeRange() {
        System.out.print("Nhap do tuoi nho nhat: ");
        int minAge = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap do tuoi lon nhat: ");
        int maxAge = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = employeeService.searchEmployeeByAgeRange(minAge, maxAge);
        if (employees != null && !employees.isEmpty()) {
            System.out.println("===== Ket qua tim kiem =====");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Khong co nhan vien trong do tuoi nay!");
        }
    }

    private void sortEmployeesBySalaryDesc() {
        List<Employee> employees = employeeService.sortEmployeesBySalaryDesc();
        if (employees != null && !employees.isEmpty()) {
            System.out.println("===== Danh sach nhan vien theo luong giam dan =====");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Khong co nhan vien nao!");
        }
    }

    private void sortEmployeesByNameAsc() {
        List<Employee> employees = employeeService.sortEmployeesByNameAsc();
        if (employees != null && !employees.isEmpty()) {
            System.out.println("===== Danh sach nhan vien theo ten tang dan =====");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Khong co nhan vien nao!");
        }
    }

    private void showStatisticsMenu() {
        while (true) {
            System.out.println("\n===== THONG KE NHAN VIEN =====");
            System.out.println("1. Tong so nhan vien");
            System.out.println("0. Quay lai menu nhan vien");
            System.out.print("Chon chuc nang: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeService.statisticTotalEmployees();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
