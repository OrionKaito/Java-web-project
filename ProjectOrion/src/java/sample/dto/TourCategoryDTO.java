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
public class TourCategoryDTO implements Serializable{
    private String id;
    private String name;

    public TourCategoryDTO() {
    }

    public TourCategoryDTO(String name, String id) {
        this.name = name;
        this.id = id;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
