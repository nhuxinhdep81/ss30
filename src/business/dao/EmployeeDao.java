package business.dao;

import business.config.ConnectionDB;
import business.model.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public List<Employee> getEmployeesByPage(int pageNumber) {
        List<Employee> employees = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_employees_by_page(?)}");
            callSt.setInt(1, pageNumber);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setEmpName(rs.getString("emp_name"));
                emp.setEmpEmail(rs.getString("emp_email"));
                emp.setEmpPhone(rs.getString("emp_phone"));
                emp.setEmpGender(rs.getString("emp_gender"));
                emp.setEmpGrade(rs.getInt("emp_grade"));
                emp.setEmpSalary(rs.getDouble("emp_salary"));
                emp.setEmpBirth(rs.getDate("emp_birth").toLocalDate());
                emp.setEmpAddress(rs.getString("emp_address"));
                emp.setEmpStatus(rs.getString("emp_status"));
                emp.setDeptId(rs.getInt("dept_id"));
                employees.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    public void addEmployee(Employee emp) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_employee(?,?,?,?,?,?,?,?,?,?,?)}");
            callSt.setString(1, emp.getEmpId());
            callSt.setString(2, emp.getEmpName());
            callSt.setString(3, emp.getEmpEmail());
            callSt.setString(4, emp.getEmpPhone());
            callSt.setString(5, emp.getEmpGender());
            callSt.setInt(6, emp.getEmpGrade());
            callSt.setDouble(7, emp.getEmpSalary());
            callSt.setDate(8, Date.valueOf(emp.getEmpBirth()));
            callSt.setString(9, emp.getEmpAddress());
            callSt.setString(10, emp.getEmpStatus());
            callSt.setInt(11, emp.getDeptId());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    public void updateEmployee(Employee emp) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_employee(?,?,?,?,?,?,?,?,?,?,?)}");
            callSt.setString(1, emp.getEmpId());
            callSt.setString(2, emp.getEmpName());
            callSt.setString(3, emp.getEmpEmail());
            callSt.setString(4, emp.getEmpPhone());
            callSt.setString(5, emp.getEmpGender());
            callSt.setInt(6, emp.getEmpGrade());
            callSt.setDouble(7, emp.getEmpSalary());
            callSt.setDate(8, Date.valueOf(emp.getEmpBirth()));
            callSt.setString(9, emp.getEmpAddress());
            callSt.setString(10, emp.getEmpStatus());
            callSt.setInt(11, emp.getDeptId());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    public void deleteEmployee(String empId) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_employee(?)}");
            callSt.setString(1, empId);
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    public List<Employee> searchEmployeeByName(String empName) {
        List<Employee> employees = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_employee_by_name(?)}");
            callSt.setString(1, empName);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setEmpName(rs.getString("emp_name"));
                emp.setEmpEmail(rs.getString("emp_email"));
                emp.setEmpPhone(rs.getString("emp_phone"));
                emp.setEmpGender(rs.getString("emp_gender"));
                emp.setEmpGrade(rs.getInt("emp_grade"));
                emp.setEmpSalary(rs.getDouble("emp_salary"));
                emp.setEmpBirth(rs.getDate("emp_birth").toLocalDate());
                emp.setEmpAddress(rs.getString("emp_address"));
                emp.setEmpStatus(rs.getString("emp_status"));
                emp.setDeptId(rs.getInt("dept_id"));
                employees.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    public List<Employee> searchEmployeeByAgeRange(int minAge, int maxAge) {
        List<Employee> employees = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_employee_by_age_range(?,?)}");
            callSt.setInt(1, minAge);
            callSt.setInt(2, maxAge);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setEmpName(rs.getString("emp_name"));
                emp.setEmpEmail(rs.getString("emp_email"));
                emp.setEmpPhone(rs.getString("emp_phone"));
                emp.setEmpGender(rs.getString("emp_gender"));
                emp.setEmpGrade(rs.getInt("emp_grade"));
                emp.setEmpSalary(rs.getDouble("emp_salary"));
                emp.setEmpBirth(rs.getDate("emp_birth").toLocalDate());
                emp.setEmpAddress(rs.getString("emp_address"));
                emp.setEmpStatus(rs.getString("emp_status"));
                emp.setDeptId(rs.getInt("dept_id"));
                employees.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    public List<Employee> sortEmployeesBySalaryDesc() {
        List<Employee> employees = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sort_employees_by_salary_desc()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setEmpName(rs.getString("emp_name"));
                emp.setEmpEmail(rs.getString("emp_email"));
                emp.setEmpPhone(rs.getString("emp_phone"));
                emp.setEmpGender(rs.getString("emp_gender"));
                emp.setEmpGrade(rs.getInt("emp_grade"));
                emp.setEmpSalary(rs.getDouble("emp_salary"));
                emp.setEmpBirth(rs.getDate("emp_birth").toLocalDate());
                emp.setEmpAddress(rs.getString("emp_address"));
                emp.setEmpStatus(rs.getString("emp_status"));
                emp.setDeptId(rs.getInt("dept_id"));
                employees.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    public List<Employee> sortEmployeesByNameAsc() {
        List<Employee> employees = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sort_employees_by_name_asc()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setEmpName(rs.getString("emp_name"));
                emp.setEmpEmail(rs.getString("emp_email"));
                emp.setEmpPhone(rs.getString("emp_phone"));
                emp.setEmpGender(rs.getString("emp_gender"));
                emp.setEmpGrade(rs.getInt("emp_grade"));
                emp.setEmpSalary(rs.getDouble("emp_salary"));
                emp.setEmpBirth(rs.getDate("emp_birth").toLocalDate());
                emp.setEmpAddress(rs.getString("emp_address"));
                emp.setEmpStatus(rs.getString("emp_status"));
                emp.setDeptId(rs.getInt("dept_id"));
                employees.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    public int statisticTotalEmployees() {
        Connection conn = null;
        CallableStatement callSt = null;
        int total = 0;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call statistic_total_employees()}");
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total_employees");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return total;
    }
}