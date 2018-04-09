/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.io.Serializable;

/**
 *
 * @author Orion
 */
public class TourVSTourCategoryDTO implements Serializable {

    private String tourid, tourcategoryid;

    public TourVSTourCategoryDTO() {
    }

    public TourVSTourCategoryDTO(String tourid, String tourcategoryid) {
        this.tourid = tourid;
        this.tourcategoryid = tourcategoryid;
    }

    public String getTourid() {
        return tourid;
    }

    public void setTourid(String tourid) {
        this.tourid = tourid;
    }

    public String getTourcategoryid() {
        return tourcategoryid;
    }

    public void setTourcategoryid(String tourcategoryid) {
        this.tourcategoryid = tourcategoryid;
    }

}
