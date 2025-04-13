package business.service;

import business.dao.DepartmentDao;
import business.model.Department;
import business.utils.Validator;

import java.util.List;

public class DepartmentService {
    private DepartmentDao departmentDao;

    public DepartmentService() {
        this.departmentDao = new DepartmentDao();
    }

    public List<Department> getDepartmentsByPage(int pageNumber) {
        if (pageNumber < 1) {
            System.out.println("So trang phai lon hon 0!");
            return null;
        }
        return departmentDao.getDepartmentsByPage(pageNumber);
    }

    public void addDepartment(String deptName, String description, String status) {
        if (!Validator.isValidName(deptName, 10, 100)) {
            System.out.println("ten phong ban phai tu 10-100 ki tu!");
            return;
        }
        if (description != null && description.length() > 255) {
            System.out.println("mo ta khong duoc qua 255 ki tu!");
            return;
        }
        if (!status.equals("ACTIVE") && !status.equals("INACTIVE")) {
            System.out.println("trang thai chi co ACTIVE va INACTIVE!");
            return;
        }
        Department dept = new Department(0, deptName, description, status);
        departmentDao.addDepartment(dept);
        System.out.println("Them phong ban thanh cong!");
    }

    public void updateDepartment(int deptId, String status) {
        if (!status.equals("ACTIVE") && !status.equals("INACTIVE")) {
            System.out.println("trang thai chi co ACTIVE va INACTIVE!");
            return;
        }
        departmentDao.updateDepartment(deptId, status);
        System.out.println("Cap nhat phong ban thanh cong!");
    }

    public void deleteDepartment(int deptId) {
        int result = departmentDao.deleteDepartment(deptId);
        if (result == 1) {
            System.out.println("Phòng ban đã được xóa thành công!");
        } else if (result == -1) {
            System.out.println("Không thể xóa phòng ban vì vẫn còn nhân viên!");
        } else {
            System.out.println("Không tìm thấy phòng ban với ID: " + deptId);
        }
    }

    public List<Department> searchDepartmentByName(String deptName) {
        if (deptName == null || deptName.trim().isEmpty()) {
            System.out.println("Ten tim kiem khong duoc trong!");
            return null;
        }
        return departmentDao.searchDepartmentByName(deptName);
    }

    public void statisticEmployeeCountByDepartment() {
        List<Object[]> stats = departmentDao.statisticEmployeeCountByDepartment();
        System.out.println("===== Thong ke nhan vien theo phong ban =====");
        for (Object[] row : stats) {
            System.out.printf("Id phong ban: %d, Ten phong ban: %s, Tong so nv: %d%n", row[0], row[1], row[2]);
        }
    }

    public void statisticDepartmentMostEmployees() {
        Object[] result = departmentDao.statisticDepartmentMostEmployees();
        if (result != null) {
            System.out.println("===== Phong ban co nhieu nv nhat =====");
            System.out.printf("Id phong ban: %d, Ten phong ban: %s, Tong so nv: %d%n", result[0], result[1], result[2]);
        } else {
            System.out.println("Khong tim thay phong ban nao nhan vien!");
        }
    }

    public void statisticDepartmentHighestSalary() {
        Object[] result = departmentDao.statisticDepartmentHighestSalary();
        if (result != null) {
            System.out.println("===== Phong ban co luong cao nhat =====");
            System.out.printf("Id phong ban: %d, Ten phong ban: %s, Tong luong: %.2f%n", result[0], result[1], result[2]);
        } else {
            System.out.println("Khong tim thay phong ban nao nhan vien");
        }
    }
}