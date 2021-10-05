/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.tblOrderDetails;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phucnt.ultils.DBIHelper;

/**
 *
 * @author PC
 */
public class OrderDetailsDAO implements Serializable{
    List<OrderDetailsDTO> orderdetailsList;

    public List<OrderDetailsDTO> getOrderdetailsList() {
        return orderdetailsList;
    }
    
    public boolean addOrderDetails(String orderDetailsID, String productID, 
            String orderID, int price, int quantity)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. connect DB
            con = DBIHelper.getConnection();
            if (con != null) {

                //2. create string sql
                String sql = "Insert into tblOrderDetails(orderDetailsID, productID, orderID, price, quantity) "
                        + "Values(?, ?, ?, ?, ?)";
                //3.create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, orderDetailsID);
                stm.setString(2, productID);
                stm.setString(3, orderID);
                stm.setInt(4, price);
                stm.setInt(5, quantity);
                //4. execute stm and get int
                int row = stm.executeUpdate();
                //5. execute row to get int
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

    public void searchOrderDetails(String orderDetailsID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. connect DB
            con = DBIHelper.getConnection();

            if (con != null) {
                //2. create string sql
                String sql = "SELECT orderDetailsID, productID, orderID, price, quantity "
                        + "FROM tblOrderDetails "
                        + "WHERE orderDetailsID like ?";
                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, orderDetailsID);

                //4.execute stm and get rs
                rs = stm.executeQuery();
                //5. process rs
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String orderID = rs.getString("orderID");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    //tao DTO obj chua 4 du lieu o tren
                    OrderDetailsDTO dto = new OrderDetailsDTO(orderDetailsID, productID, orderID, price, quantity);

                    if (this.orderdetailsList == null) {
                        this.orderdetailsList = new ArrayList<>();
                    } //end if orderdetailsList is not existed
                    this.orderdetailsList.add(dto);
                    
                } //end if while traversing result
            } //end if con existed
        } finally {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }

    }
}
