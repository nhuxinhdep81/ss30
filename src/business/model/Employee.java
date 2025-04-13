package business.model;

import java.time.LocalDate;

public class Employee {
    private String empId;
    private String empName;
    private String empEmail;
    private String empPhone;
    private String empGender;
    private int empGrade;
    private double empSalary;
    private LocalDate empBirth;
    private String empAddress;
    private String empStatus;
    private int deptId;

    public Employee() {}

    public Employee(String empId, String empName, String empEmail, String empPhone, String empGender,
                    int empGrade, double empSalary, LocalDate empBirth, String empAddress,
                    String empStatus, int deptId) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.empGender = empGender;
        this.empGrade = empGrade;
        this.empSalary = empSalary;
        this.empBirth = empBirth;
        this.empAddress = empAddress;
        this.empStatus = empStatus;
        this.deptId = deptId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public int getEmpGrade() {
        return empGrade;
    }

    public void setEmpGrade(int empGrade) {
        this.empGrade = empGrade;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public LocalDate getEmpBirth() {
        return empBirth;
    }

    public void setEmpBirth(LocalDate empBirth) {
        this.empBirth = empBirth;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empGender='" + empGender + '\'' +
                ", empGrade=" + empGrade +
                ", empSalary=" + empSalary +
                ", empBirth=" + empBirth +
                ", empAddress='" + empAddress + '\'' +
                ", empStatus='" + empStatus + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}