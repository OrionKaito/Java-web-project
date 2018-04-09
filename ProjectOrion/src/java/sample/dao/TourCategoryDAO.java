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
import sample.dto.TourCategoryDTO;
import sample.ulti.ulti;

/**
 *
 * @author Orion
 */
public class TourCategoryDAO implements Serializable{
    private Connection con;
    private PreparedStatement psm;
    private ResultSet rs;
    
    public boolean createTourCategory(String id, String name) throws SQLException, ClassNotFoundException {
        boolean check;
        try {
            String sql = "insert into TourCategory (id, tourcategoryname) values (?, ?)";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, id);
            psm.setString(2, name);
            check = psm.executeUpdate() > 0;
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return check;
    }
    
    public List<TourCategoryDTO> getAllCategoryName() throws SQLException, ClassNotFoundException {
        List<TourCategoryDTO> result = null;
        try {
            String sql = "select TourCategoryName, id from TourCategory";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            rs = psm.executeQuery();
            String id;
            String name;
            result = new ArrayList<>();
            while (rs.next()){
                id = rs.getString("id");
                name = rs.getString("TourCategoryName");
                TourCategoryDTO dto = new TourCategoryDTO(name, id);
                result.add(dto);
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return result;
    }
    
}
