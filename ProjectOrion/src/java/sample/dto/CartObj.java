/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Orion
 */
public class CartObj implements Serializable{
    private String customerName;
    private HashMap<String, TourDTO> cart;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, TourDTO> getCart() {
        return cart;
    }

    public CartObj() {
        this.customerName = "Guest";
        this.cart = new HashMap<>();
    }

    public CartObj(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }

    public void addToCart(TourDTO dto) throws Exception {
        if (this.cart.containsKey(dto.getId())) {
            int quantity = this.cart.get(dto.getId()).getQuantity() + 1;
            dto.setQuantity(quantity);
        }
        this.cart.put(dto.getId(), dto);
    }

    public void remove(String id) throws Exception {
        this.cart.remove(id);
    }

    public float getTotal() {
        float result = 0;
        for (TourDTO dto : this.cart.values()) {
            result += dto.getQuantity() * dto.getPrice();
        }
        return result;
    }
}
