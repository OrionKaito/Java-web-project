/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.ulti;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.Part;

/**
 *
 * @author Orion
 */
public class ulti implements Serializable {

    public static void closeConnection(Connection con, PreparedStatement psm, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (psm != null) {
            psm.close();
        }
        if (con != null) {
            con.close();
        }
    }
    
    public static String extractfilename(Part file) {
        String disposition = file.getHeader("content-disposition");
        String[] itemsList = disposition.split(";");
        for (String item : itemsList) {
            if (item.trim().startsWith("filename")) {
                String filelocation = item.substring(item.indexOf("=") + 2, item.length() - 1);
                int lastIndex = filelocation.lastIndexOf("/");
                return filelocation.substring(lastIndex + 1);
            }
        }

        return "";
    }
}
