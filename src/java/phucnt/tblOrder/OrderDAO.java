/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.tblOrder;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import javax.naming.NamingException;
import phucnt.ultils.DBIHelper;

/**
 *
 * @author PC
 */
public class OrderDAO implements Serializable {
    private String lastOrderID;
    private long maxOfOrder = 9000;
    private List<OrderDTO> orderList;

    public List<OrderDTO> getOrderList() {
        return orderList;
    }

    public boolean addOrder(String orderID, String userID, Date date, float total)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1.connect DB
            con = DBIHelper.getConnection();
            if (con != null) {

                //2. create string sql
                String sql = "Insert into tblOrder(orderID, userID, Date, total) "
                        + "Values(?, ?, ?, ?)";
                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, orderID);
                stm.setString(2, userID);
                stm.setDate(3, date);
                stm.setFloat(4, total);
                //4. process stm and get row
                int row = stm.executeUpdate();
                //5. process row
                if (row > 0) {
                    return true;
                } //end if row existed
            } //end if con existed
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    // orderID là tự tạo mà, nên cái này hơi dư
    public boolean IsOrderIDtaken(String orderID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. connect DB
            con = DBIHelper.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "Select orderID "
                        + "From tblOrder "
                        + "Where orderID like ?";

                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, orderID);
                //4. execute stm and get rs
                rs = stm.executeQuery();

                //process rs 
                if (rs.next()) {
                    return true;
                } //end if rs existed
            } //end if con existed
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
    
    public String autoGenerateOrderID()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. connect DB
            con = DBIHelper.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "Select orderID "
                        + "From tblOrder "
                        + "Where orderID like ?";

                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, lastOrderID);
                //4. execute stm and get rs
                rs = stm.executeQuery();

                //process rs 
                if (rs.next()) {
                    return "";
                } //end if rs existed
            } //end if con existed
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return null;
    }
}
