/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.tblOrderDetails;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class OrderDetailsDTO implements Serializable{
    private String orderDetailsID;
    private String productID;
    private String orderID;
    private int price;
    private int quantity;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String orderDetailsID, String productID, String orderID, int price, int quantity) {
        this.orderDetailsID = orderDetailsID;
        this.productID = productID;
        this.orderID = orderID;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * @return the orderDetailsID
     */
    public String getOrderDetailsID() {
        return orderDetailsID;
    }

    /**
     * @param orderDetailsID the orderDetailsID to set
     */
    public void setOrderDetailsID(String orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    /**
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
