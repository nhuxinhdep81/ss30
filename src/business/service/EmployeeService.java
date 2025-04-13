package business.service;

import business.dao.EmployeeDao;
import business.model.Employee;
import business.utils.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService() {
        this.employeeDao = new EmployeeDao();
    }

    public List<Employee> getEmployeesByPage(int pageNumber) {
        if (pageNumber < 1) {
            System.out.println("So trang phai lon hon 0!");
            return null;
        }
        return employeeDao.getEmployeesByPage(pageNumber);
    }

    public void addEmployee(String empId, String empName, String empEmail, String empPhone, String empGender,
                            int empGrade, double empSalary, String empBirthStr, String empAddress,
                            String empStatus, int deptId) {
        if (!Validator.isValidEmpId(empId)) {
            System.out.println("Id phai bat dau tu 'E' va theo sau la 5 ki tu!");
            return;
        }
        if (!Validator.isValidName(empName, 15, 150)) {
            System.out.println("do dai ten nv phai tu 15 den 150 ki tu");
            return;
        }
        if (!Validator.isValidEmail(empEmail)) {
            System.out.println("Dinh dang email khong hop le!");
            return;
        }
        if (!Validator.isValidPhone(empPhone)) {
            System.out.println("Dinh dang sdt ko hop le!");
            return;
        }
        if (!empGender.equals("MALE") && !empGender.equals("FEMALE") && !empGender.equals("OTHER")) {
            System.out.println("gioi tinh khong hop le!");
            return;
        }
        if (!Validator.isValidGrade(empGrade)) {
            System.out.println("Bac luong phai lon hon 0!");
            return;
        }
        if (!Validator.isValidSalary(empSalary)) {
            System.out.println("Luong p[hai lon hon 0!");
            return;
        }
        if (!Validator.isValidDate(empBirthStr)) {
            System.out.println("dinh dang ko hop le, hay dung dd/MM/yyyy");
            return;
        }
        if (empAddress == null || empAddress.trim().isEmpty()) {
            System.out.println("Dia chi ko dc de trong");
            return;
        }
        if (!empStatus.equals("ACTIVE") && !empStatus.equals("INACTIVE") && !empStatus.equals("ONLEAVE") && !empStatus.equals("POLICYLEAVE")) {
            System.out.println("trang thai ko hop  le!");
            return;
        }

        LocalDate empBirth = LocalDate.parse(empBirthStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Employee emp = new Employee(empId, empName, empEmail, empPhone, empGender, empGrade, empSalary,
                empBirth, empAddress, empStatus, deptId);
        employeeDao.addEmployee(emp);
        System.out.println("Them nv thanh cong!");
    }

    public void updateEmployee(String empId, String empName, String empEmail, String empPhone, String empGender,
                               int empGrade, double empSalary, String empBirthStr, String empAddress,
                               String empStatus, int deptId) {
        if (!Validator.isValidEmpId(empId)) {
            System.out.println("Id khong hop le!");
            return;
        }
        if (!Validator.isValidName(empName, 15, 150)) {
            System.out.println("do dai ten ko phu ");
            return;
        }
        if (!Validator.isValidEmail(empEmail)) {
            System.out.println("email khong hop le!");
            return;
        }
        if (!Validator.isValidPhone(empPhone)) {
            System.out.println("Dinh dang so dien thoai khong hop le!");
            return;
        }
        if (!empGender.equals("MALE") && !empGender.equals("FEMALE") && !empGender.equals("OTHER")) {
            System.out.println("Gioi tinh khong hop le!");
            return;
        }
        if (!Validator.isValidGrade(empGrade)) {
            System.out.println("Bac luong phai lon hon 0!");
            return;
        }
        if (!Validator.isValidSalary(empSalary)) {
            System.out.println("Luong phai lon hoin 0!");
            return;
        }
        if (!Validator.isValidDate(empBirthStr)) {
            System.out.println("dinh dang phai theo dd/mm/yyy");
            return;
        }
        if (empAddress == null || empAddress.trim().isEmpty()) {
            System.out.println("Dia chi khong duoc trong!");
            return;
        }
        if (!empStatus.equals("ACTIVE") && !empStatus.equals("INACTIVE") && !empStatus.equals("ONLEAVE") && !empStatus.equals("POLICYLEAVE")) {
            System.out.println("Status khong hop le!");
            return;
        }

        LocalDate empBirth = LocalDate.parse(empBirthStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Employee emp = new Employee(empId, empName, empEmail, empPhone, empGender, empGrade, empSalary,
                empBirth, empAddress, empStatus, deptId);
        employeeDao.updateEmployee(emp);
        System.out.println("THEM nhan vien thanh cong!");
    }

    public void deleteEmployee(String empId) {
        if (!Validator.isValidEmpId(empId)) {
            System.out.println("ID nv phai bat dau la E va theo sau la 5 ki tu");
            return;
        }
        employeeDao.deleteEmployee(empId);
        System.out.println("Cap nhat trang thai employ thanh inactive!");
    }

    public List<Employee> searchEmployeeByName(String empName) {
        if (empName == null || empName.trim().isEmpty()) {
            System.out.println("Ten tim kiem khong duoc trong!");
            return null;
        }
        return employeeDao.searchEmployeeByName(empName);
    }

    public List<Employee> searchEmployeeByAgeRange(int minAge, int maxAge) {
        if (minAge < 0 || maxAge < minAge) {
            System.out.println("Tuoi nhap vao khong hop le!");
            return null;
        }
        return employeeDao.searchEmployeeByAgeRange(minAge, maxAge);
    }

    public List<Employee> sortEmployeesBySalaryDesc() {
        return employeeDao.sortEmployeesBySalaryDesc();
    }

    public List<Employee> sortEmployeesByNameAsc() {
        return employeeDao.sortEmployeesByNameAsc();
    }

    public void statisticTotalEmployees() {
        int total = employeeDao.statisticTotalEmployees();
        System.out.println("===== Tong so nv =====");
        System.out.println("Tong so nv: " + total);
    }
}