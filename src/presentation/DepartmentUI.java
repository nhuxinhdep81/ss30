package presentation;

import business.model.Department;
import business.service.DepartmentService;

import java.util.List;
import java.util.Scanner;

public class DepartmentUI {
    private DepartmentService departmentService;
    private Scanner scanner;

    public DepartmentUI() {
        this.departmentService = new DepartmentService();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== Quan ly phong ban =====");
            System.out.println("1. Danh sach phong ban co phan trang");
            System.out.println("2. Them phong ban");
            System.out.println("3. Cap nhat phong ban(chi co the update trang thai)");
            System.out.println("4. Xoa phong ban");
            System.out.println("5. Tim kiem phong ban theo ten");
            System.out.println("6. Thong ke phong ban");
            System.out.println("0. Quay lai MENU chinh");
            System.out.print("Chon 1 lua chon: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayDepartmentsByPage();
                    break;
                case 2:
                    addDepartment();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    deleteDepartment();
                    break;
                case 5:
                    searchDepartmentByName();
                    break;
                case 6:
                    showStatisticsMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Luia chon ko hop le, hay chon lai!");
            }
        }
    }

    private void displayDepartmentsByPage() {
        System.out.print("Nhap vao so trang: ");
        int pageNumber = Integer.parseInt(scanner.nextLine());
        List<Department> departments = departmentService.getDepartmentsByPage(pageNumber);
        if (departments != null && !departments.isEmpty()) {
            System.out.println("===== DAnh sach phong ban (Trang " + pageNumber + ") =====");
            for (Department dept : departments) {
                System.out.println(dept);
            }
        } else {
            System.out.println("Khong co phong ban nao o trang nay!");
        }
    }

    private void addDepartment() {
        System.out.print("Nhap ten phong ban (10-100 ki tu): ");
        String deptName = scanner.nextLine();
        System.out.print("Nhap mo ta phong ban (max la 255 ki tu): ");
        String description = scanner.nextLine();
        System.out.print("Nhap trang thai phong ban (ACTIVE/INACTIVE): ");
        String status = scanner.nextLine().toUpperCase();
        departmentService.addDepartment(deptName, description, status);
    }

    private void updateDepartment() {
        System.out.print("Nhap id phong ban can cap nhat: ");
        int deptId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap vao trang thai moi (ACTIVE/INACTIVE): ");
        String status = scanner.nextLine().toUpperCase();
        departmentService.updateDepartment(deptId, status);
    }

    private void deleteDepartment() {
        System.out.print("Nhap vao id phong ban can xoas: ");
        int deptId = Integer.parseInt(scanner.nextLine());
        departmentService.deleteDepartment(deptId);
    }

    private void searchDepartmentByName() {
        System.out.print("Nhap vao ten phong ban can tim: ");
        String deptName = scanner.nextLine();
        List<Department> departments = departmentService.searchDepartmentByName(deptName);
        if (departments != null && !departments.isEmpty()) {
            System.out.println("===== Ket qua tim kiem =====");
            for (Department dept : departments) {
                System.out.println(dept);
            }
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    private void showStatisticsMenu() {
        while (true) {
            System.out.println("\n===== THONG KE PHONG BAN =====");
            System.out.println("1. SO LUONG NHAN VIEN THEO PHONG BAN");
            System.out.println("2. PHONG BAN CO NHIEU NV NHAT");
            System.out.println("3. PHONG BAN CO LUONG CAO NHAT");
            System.out.println("0. Tro lai MENU quan ly phong ban");
            System.out.print("Lua chon cua ban: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    departmentService.statisticEmployeeCountByDepartment();
                    break;
                case 2:
                    departmentService.statisticDepartmentMostEmployees();
                    break;
                case 3:
                    departmentService.statisticDepartmentHighestSalary();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}