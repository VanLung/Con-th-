/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.tblProducts;

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
public class ProductDAO implements Serializable {

    public List<ProductDTO> searchProduct(String search)
            throws SQLException, NamingException {
        List<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "Select productID, productName, quantity, price, catagoryID "
                        + "From tblProducts "
                        + "Where productName like ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");

                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    int quantity = rs.getInt("quantity");
                    int price = rs.getInt("price");
                    String catagoryID = rs.getString("catagoryID");

                    ProductDTO dto = new ProductDTO(productID, productName, quantity, price, catagoryID);
                    list.add(dto);
                }
            }

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

        return list;
    }

    public boolean deleteProduct(String productID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "Delete FROM tblProducts "
                        + "Where productID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, productID);

                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }

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

    public boolean UpdateProduct(String productID, int quantity, int price, String catagoryID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "UPDATE tblProducts "
                        + "SET quantity = ?, "
                        + "price = ?, "
                        + "catagoryID = ? "
                        + "WHERE productID = ? ";

                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setInt(2, price);
                stm.setString(3, catagoryID);
                stm.setString(4, productID);

                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }

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

    public boolean InsertProduct(String productID, String productName, int quantity, int price, String categoryID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "Insert INTO tblProducts(productID, productName, quantity, price, catagoryID) "
                        + "Values(?, ?, ?, ?, ?) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, productID);
                stm.setString(2, productName);
                stm.setInt(3, quantity);
                stm.setInt(4, price);
                stm.setString(5, categoryID);

                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }

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

    private List<ProductDTO> productList;

    public ProductDTO getProductInfo(String productID, int quantity) throws SQLException, NamingException {
       
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "SELECT productName, price, catagoryID "
                        + "FROM tblProducts "
                        + "WHERE productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, productID);

                rs = stm.executeQuery();
                if(rs.next()) {
                    String productName = rs.getString("productName");
                    int price = rs.getInt("price");
                    String catagoryID = rs.getString("catagoryID");
                    ProductDTO dto = new ProductDTO(productID, productName, 
                            quantity, price, catagoryID);
                    return dto;
                }
            }

        } finally {
            if(rs != null){
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
    
    public int getProductRemaining(String productID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "SELECT quantity "
                        + "FROM tblProducts "
                        + "WHERE productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, productID);

                rs = stm.executeQuery();
                if(rs.next()) {
                    int remaining = rs.getInt("quantity");
                    return remaining;
                }
            }

        } finally {
            if(rs != null){
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        //ko tìm dc product / có lỗi xảy ra
        return -1;
    }
    
    
    public List<ProductDTO> showFlower() throws SQLException, NamingException {
        //List<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "Select productID, productName, quantity, price, catagoryID "
                        + "From tblProducts ";
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    int quantity = rs.getInt("quantity");
                    int price = rs.getInt("price");
                    String cateogoryID = rs.getString("catagoryID");

                    ProductDTO dto = new ProductDTO(productID, productName, quantity, price, cateogoryID);
                    if (this.productList == null) {
                        this.productList = new ArrayList<>();
                    }
                    this.productList.add(dto);
                }
                return productList;
            }

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
    
    public boolean IsProductNametaken(String productName) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. connect DB
            con = DBIHelper.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "Select productName "
                        + "From tblProducts "
                        + "Where productName like ?";

                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, productName);
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
}
