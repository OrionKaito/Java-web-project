/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.dbo.MyConnection;
import sample.dto.RegistrationDTO;
import sample.ulti.ulti;

/**
 *
 * @author Orion
 */
public class RegistrationDAO implements Serializable {

    private static Connection con = null;
    private static PreparedStatement psm = null;
    private static ResultSet rs = null;

    public RegistrationDAO() {
    }

    public String checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        String role = "failed";
        try {
            String sql = "select Role from Registration where username = ? and password = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, username);
            psm.setString(2, password);
            rs = psm.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return role;
    }

    public boolean register(RegistrationDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "insert into Registration (username, password, email, phone, role) values ( ?, ?, ?, ?, ?)";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, dto.getUsername());
            psm.setString(2, dto.getPassword());
            psm.setString(3, dto.getEmail());
            psm.setString(4, dto.getPhone());
            psm.setString(5, dto.getRole());
            check = psm.executeUpdate() > 0;
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return check;
    }

    public List<RegistrationDTO> findByLikeUsernamePaging(String search, int firstResult, int maxResult) throws SQLException, ClassNotFoundException {
        List<RegistrationDTO> result = null;
        try {
            String sql = "select userid, username,email, phone, role from registration where UserName like ? Order by userid ASC OFFSET  ? ROWS FETCH NEXT ? ROWS ONLY";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, "%" + search + "%");
            psm.setInt(2, firstResult);
            psm.setInt(3, maxResult);
            rs = psm.executeQuery();
            String username, email, phone, role;
            int id;
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("username");
                email = rs.getString("email");
                role = rs.getString("role");
                phone = rs.getString("phone");
                id = rs.getInt(1);
                RegistrationDTO dto = new RegistrationDTO(username, role, email, phone, id);
                result.add(dto);
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return result;
    }
    
    public List<RegistrationDTO> findByUsernameP(String search) throws SQLException, ClassNotFoundException {
        List<RegistrationDTO> result = null;
        try {
            String sql = "select password, username,email, phone from registration where UserName = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, search);
            rs = psm.executeQuery();
            String username, email, phone, role, password;
            int id;
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("username");
                email = rs.getString("email");
                phone = rs.getString("phone");
                id = rs.getInt(1);
                password = rs.getString("password");
                RegistrationDTO dto = new RegistrationDTO(username, password, email, phone);
                result.add(dto);
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return result;
    }
    
    public List<RegistrationDTO> getAllUsernamePaging(int firstResult, int maxResult) throws SQLException, ClassNotFoundException {
        List<RegistrationDTO> result = null;
        try {
            String sql = "SELECT userid, username, email, phone, role FROM Registration Order BY userid ASC OFFSET  ? ROWS FETCH NEXT ? ROWS ONLY"; 
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setInt(1, firstResult);
            psm.setInt(2, maxResult);
            rs = psm.executeQuery();
            result = new ArrayList<>();
            String username, email, phone, role;
            int id;
            while (rs.next()) {
                username = rs.getString("username");
                email = rs.getString("email");
                phone = rs.getString("phone");
                role = rs.getString("role");
                id = rs.getInt(1);
                RegistrationDTO dto = new RegistrationDTO(username, role, email, phone, id);
                result.add(dto);
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return result;
    }

    public int countAccount() throws SQLException, ClassNotFoundException {
        int count = 0;
        try {
            String sql = "select count(userid) from registration";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1); 
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return count;
    }
    
    public int countAccountSearch(String search) throws SQLException, ClassNotFoundException {
        int count = 0;
        try {
            String sql = "select count(userid) from registration where username like ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, "%" + search + "%");
            rs = psm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1); //*
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return count;
    }
    
    public boolean deleteUser(String username) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "delete from registration where username = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, username);
            check = psm.executeUpdate() > 0;
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return check;
    }
    
    public boolean updateRole(String username, String role) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "update registration set role = ? where username = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, role);
            psm.setString(2, username);
            check = psm.executeUpdate() > 0;
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return check;
    }
    
    public boolean update(RegistrationDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "update registration set password = ?, email = ?, phone = ? where username = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, dto.getPassword());
            psm.setString(2, dto.getEmail());
            psm.setString(3, dto.getPhone());
            psm.setString(4, dto.getUsername());
            check = psm.executeUpdate() > 0;
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return check;
    }
}
