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
import sample.dto.TourVSTourCategoryDTO;
import sample.ulti.ulti;

/**
 *
 * @author Orion
 */
public class TourVSTourCategoryDAO implements Serializable{
    private Connection con;
    private PreparedStatement psm;
    private ResultSet rs;
    
    public boolean insert(String tourID, String tourcategoryID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql ="insert into TourVSTourCategory (tourid, tourcategoryid) values ( ?, ?)";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, tourID);
            psm.setString(2, tourcategoryID);
            check = psm.executeUpdate() > 0;
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return check;
    }
    
    public boolean deleteRelateCategory(String tourid) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "delete from TourVSTourCategory where tourid = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, tourid);
            check = psm.executeUpdate() > 0;
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return check;
    }
    
    public List<TourVSTourCategoryDTO> findRelateCategory(String tourid) throws SQLException, ClassNotFoundException {
        List<TourVSTourCategoryDTO> result = null;
        try {
            String sql = "select tourid, tourcategoryID from TourVSTourCategory where tourid = ?";
            con = MyConnection.makeConnection();
            psm = con.prepareStatement(sql);
            psm.setString(1, tourid);
            rs = psm.executeQuery();
            result = new ArrayList<>();
            String tourcategoryid;
            while (rs.next()) {
                tourcategoryid = rs.getString("TourCategoryID");
                TourVSTourCategoryDTO dto = new TourVSTourCategoryDTO(tourid, tourcategoryid);
                result.add(dto);
            }
        } finally {
            ulti.closeConnection(con, psm, rs);
        }
        return result;
    }
}
