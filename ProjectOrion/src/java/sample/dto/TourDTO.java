/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Orion
 */
public class TourDTO implements Serializable{
    private String id;
    private String tourname;
    private int price;
    private String description;
    private String filepath;
    private String start;
    private String arrival;
    private int maxCustomer;
    private java.sql.Date date;
    private String filename;
    
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    

    public TourDTO() {
    }

    public TourDTO(String id, String tourname, int price, String description, String filepath, String start, String arrival, int maxCustomer, Date date, String filename) {
        this.id = id;
        this.tourname = tourname;
        this.price = price;
        this.description = description;
        this.filepath = filepath;
        this.start = start;
        this.arrival = arrival;
        this.maxCustomer = maxCustomer;
        this.date = date;
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getMaxCustomer() {
        return maxCustomer;
    }

    public void setMaxCustomer(int maxCustomer) {
        this.maxCustomer = maxCustomer;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getTourname() {
        return tourname;
    }

    public void setTourname(String tourname) {
        this.tourname = tourname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public TourDTO(String id, String tourname, int price) {
        this.id = id;
        this.tourname = tourname;
        this.price = price;
    }
    
    
}
