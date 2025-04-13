package business.dao;

import business.config.ConnectionDB;
import business.model.Login;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class LoginDao {
    public Login checkLogin(String username, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        Login login = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call check_login(?, ?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                login = new Login();
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
                login.setStatus(rs.getString("status"));
                login.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return login;
    }
}