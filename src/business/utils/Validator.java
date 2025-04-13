package business.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidName(String name, int min, int max) {
        return name != null && name.length() >= min && name.length() <= max;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^(03|05|07|08|09)[0-9]{8}$");
    }

    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    public static boolean isValidGrade(int grade) {
        return grade > 0;
    }

    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidEmpId(String id) {
        return id != null && id.matches("^E\\w{4}$");
    }
}
