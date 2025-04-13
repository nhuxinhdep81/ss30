package business.dao;

import business.config.ConnectionDB;
import business.model.Department;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    public List<Department> getDepartmentsByPage(int pageNumber) {
        List<Department> departments = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_departments_by_page(?)}");
            callSt.setInt(1, pageNumber);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Department dept = new Department();
                dept.setDeptId(rs.getInt("dept_id"));
                dept.setDeptName(rs.getString("dept_name"));
                dept.setDescription(rs.getString("description"));
                dept.setStatus(rs.getString("status"));
                departments.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return departments;
    }

    public void addDepartment(Department dept) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_department(?,?,?)}");
            callSt.setString(1, dept.getDeptName());
            callSt.setString(2, dept.getDescription());
            callSt.setString(3, dept.getStatus());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    public void updateDepartment(int deptId, String status) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_department(?,?)}");
            callSt.setInt(1, deptId);
            callSt.setString(2, status);
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    public int deleteDepartment(int deptId) {
        Connection conn = null;
        CallableStatement callSt = null;
        int result = 0;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_department(?, ?)}");
            callSt.setInt(1, deptId);
            callSt.registerOutParameter(2, java.sql.Types.INTEGER);
            callSt.execute();
            result = callSt.getInt(2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public List<Department> searchDepartmentByName(String deptName) {
        List<Department> departments = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_department_by_name(?)}");
            callSt.setString(1, deptName);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Department dept = new Department();
                dept.setDeptId(rs.getInt("dept_id"));
                dept.setDeptName(rs.getString("dept_name"));
                dept.setDescription(rs.getString("description"));
                dept.setStatus(rs.getString("status"));
                departments.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return departments;
    }

    // Thống kê
    public List<Object[]> statisticEmployeeCountByDepartment() {
        List<Object[]> stats = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call statistic_employee_count_by_department()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getInt("dept_id");
                row[1] = rs.getString("dept_name");
                row[2] = rs.getInt("total_employees");
                stats.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return stats;
    }

    public Object[] statisticDepartmentMostEmployees() {
        Object[] result = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call statistic_department_most_employees()}");
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                result = new Object[3];
                result[0] = rs.getInt("dept_id");
                result[1] = rs.getString("dept_name");
                result[2] = rs.getInt("total_employees");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public Object[] statisticDepartmentHighestSalary() {
        Object[] result = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call statistic_department_highest_salary()}");
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                result = new Object[3];
                result[0] = rs.getInt("dept_id");
                result[1] = rs.getString("dept_name");
                result[2] = rs.getDouble("total_salary");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}