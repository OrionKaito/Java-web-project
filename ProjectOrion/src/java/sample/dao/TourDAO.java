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
import sample.dto.TourDTO;
import sample.ulti.ulti;

/**
 *
 * @author Orion
 */
public class TourDAO implements Serializable {

    private Connection con;
    private PreparedStatement psm;
    private ResultSet rs;

    public boolean createTour(TourDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "insert into Tour (id, name, price, description , filepath, start, arrival, maxcustomer, date, filename) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, dto.getId());
            psm.setString(2, dto.getTourname());
            psm.setInt(3, dto.getPrice());
            psm.setString(4, dto.getDescription());
            psm.setString(5, dto.getFilepath());
            psm.setString(6, dto.getStart());
            psm.setString(7, dto.getArrival());
            psm.setInt(8, dto.getMaxCustomer());
            psm.setDate(9, dto.getDate());
            psm.setString(10, dto.getFilename());
            check = psm.executeUpdate() > 0;
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return check;
    }

    public List<TourDTO> findByLikeIDPaging(String search, int firstResult, int maxResult) throws SQLException, ClassNotFoundException {
        List<TourDTO> result = null;
        try {
            String sql = "select * from Tour where ID like ? Order by id ASC OFFSET  ? ROWS FETCH NEXT ? ROWS ONLY";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, "%" + search + "%");
            psm.setInt(2, firstResult);
            psm.setInt(3, maxResult);
            rs = psm.executeQuery();
            String id, name, description, filepath, start, arrival, filename;
            int price, maxcustomer;
            java.sql.Date date;
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                description = rs.getString("description");
                filepath = rs.getString("filepath");
                start = rs.getString("start");
                arrival = rs.getString("arrival");
                price = rs.getInt("price");
                maxcustomer = rs.getInt("maxcustomer");
                date = rs.getDate("date");
                filename = rs.getString("filename");
                TourDTO dto = new TourDTO(id, name, price, description, filepath, start, arrival, maxcustomer, date, filename);
                result.add(dto);
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return result;
    }

    public List<TourDTO> findByLikeNamePaging(String search, int firstResult, int maxResult) throws SQLException, ClassNotFoundException {
        List<TourDTO> result = null;
        try {
            String sql = "select * from Tour where Name like ? Order by id ASC OFFSET  ? ROWS FETCH NEXT ? ROWS ONLY";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, "%" + search + "%");
            psm.setInt(2, firstResult);
            psm.setInt(3, maxResult);
            rs = psm.executeQuery();
            String id, name, description, filepath, start, arrival, filename;
            int price, maxcustomer;
            java.sql.Date date;
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                description = rs.getString("description");
                filepath = rs.getString("filepath");
                start = rs.getString("start");
                arrival = rs.getString("arrival");
                price = rs.getInt("price");
                maxcustomer = rs.getInt("maxcustomer");
                date = rs.getDate("date");
                filename = rs.getString("filename");
                TourDTO dto = new TourDTO(id, name, price, description, filepath, start, arrival, maxcustomer, date, filename);
                result.add(dto);
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return result;
    }
    
    public List<TourDTO> getAllTourPaging(int firstResult, int maxResult) throws SQLException, ClassNotFoundException {
        List<TourDTO> result = null;
        try {
            String sql = "select * from Tour Order by ID ASC OFFSET  ? ROWS FETCH NEXT ? ROWS ONLY";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setInt(1, firstResult);
            psm.setInt(2, maxResult);
            rs = psm.executeQuery();
            String id, name, description, filepath, start, arrival, filename;
            int price, maxcustomer;
            java.sql.Date date;
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                description = rs.getString("description");
                filepath = rs.getString("filepath");
                start = rs.getString("start");
                arrival = rs.getString("arrival");
                price = rs.getInt("price");
                maxcustomer = rs.getInt("maxcustomer");
                date = rs.getDate("date");
                filename = rs.getString("filename");
                TourDTO dto = new TourDTO(id, name, price, description, filepath, start, arrival, maxcustomer, date, filename);
                result.add(dto);
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return result;
    }

    public int countTour() throws SQLException, ClassNotFoundException {
        int count = 0;
        try {
            String sql = "select count(id) from tour";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1); //*
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return count;
    }

    public int countTourSearch(String search) throws SQLException, ClassNotFoundException {
        int count = 0;
        try {
            String sql = "select count(id) from tour where id like ?";
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

    public boolean deleteTour(String id) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "delete from tour where id = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, id);
            check = psm.executeUpdate() > 0;
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return check;
    }

    public List<TourDTO> findByID(String search) throws SQLException, ClassNotFoundException {
        List<TourDTO> result = null;
        try {
            String sql = "select * from Tour where ID = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, search);
            rs = psm.executeQuery();
            String id, name, description, filepath, start, arrival, filename;
            int price, maxcustomer;
            java.sql.Date date;
            result = new ArrayList<>();
            if (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                description = rs.getString("description");
                filepath = rs.getString("filepath");
                start = rs.getString("start");
                arrival = rs.getString("arrival");
                price = rs.getInt("price");
                maxcustomer = rs.getInt("maxcustomer");
                date = rs.getDate("date");
                filename = rs.getString("filename");
                TourDTO dto = new TourDTO(id, name, price, description, filepath, start, arrival, maxcustomer, date, filename);
                result.add(dto);
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return result;
    }
    
    public boolean update(TourDTO dto) throws SQLException {
        boolean check = false;
        try {
            String sql = "update Tour set Name = ?, price = ?, description = ?  ,filepath = ? , start = ?, arrival = ?, maxCustomer = ?, date = ?, filename = ? where id = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, dto.getTourname());
            psm.setInt(2, dto.getPrice());
            psm.setString(3, dto.getDescription());
            psm.setString(4, dto.getFilepath());
            psm.setString(5, dto.getStart());
            psm.setString(6, dto.getArrival());
            psm.setInt(7, dto.getMaxCustomer());
            psm.setDate(8, dto.getDate());
            psm.setString(9, dto.getFilename());
            psm.setString(10, dto.getId());
            check = psm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ulti.closeConnection(con, psm, rs);
        }
        return check;
    }
    
    public TourDTO findByIDDTO(String search) throws SQLException, ClassNotFoundException {
        TourDTO result = null;
        try {
            String sql = "select * from Tour where ID = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, search);
            rs = psm.executeQuery();
            String id, name, description, filepath, start, arrival, filename;
            int price, maxcustomer;
            java.sql.Date date;
            if (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                description = rs.getString("description");
                filepath = rs.getString("filepath");
                start = rs.getString("start");
                arrival = rs.getString("arrival");
                price = rs.getInt("price");
                maxcustomer = rs.getInt("maxcustomer");
                date = rs.getDate("date");
                filename = rs.getString("filename");
                TourDTO dto = new TourDTO(id, name, price, description, filepath, start, arrival, maxcustomer, date, filename);
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return result;
    }
}
