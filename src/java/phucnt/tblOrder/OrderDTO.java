/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.tblOrder;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author PC
 */
public class OrderDTO implements Serializable {
    private String orderID;
    private String userID;
    private Date date;
    private float total; 

    public OrderDTO() {
        
    }

    public OrderDTO(String orderID, String userID, Date date, float total) {
        this.orderID = orderID;
        this.userID = userID;
        this.date = date;
        this.total = total;
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
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    
    
}
