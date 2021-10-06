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
                String sql = "Select ID, proName, description, price, stock, manufacturer, category, condition,imgLink "
                        + "From tblProduct "
                        + "Where proName like ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");

                rs = stm.executeQuery();
                while (rs.next()) {
                      int ID = rs.getInt("ID");
                      String proName = rs.getString("proName");
                      String description = rs.getString("description");
                      float price = rs.getFloat("price");
                      int stock = rs.getInt("stock");
                      String manufacturer = rs.getString("manufacturer");
                      String category = rs.getString("category");
                      int condition = rs.getInt("condition");
                      String imgLink = rs.getString("imgLink");
                      
                      ProductDTO dto = new ProductDTO(ID, proName, description, price, stock, manufacturer, category, condition, imgLink);
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

    public boolean deleteProduct(int ID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "Delete FROM tblProduct "
                        + "Where ID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ID);

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

    public boolean UpdateProduct(int ID, String description , float price, int stock, String manufacturer, String category, int condition, String imgLink)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "UPDATE tblProduct "
                        + "SET description = ?, "
                        + "price = ?, "
                        + "stock = ?, "
                        + "manufacturer = ?, "
                        + "category = ?, "
                        + "condition = ?, "
                        + "imgLink = ? "                       
                        + "WHERE ID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, description);
                stm.setFloat(2, price);
                stm.setInt(3, stock);
                stm.setString(4, manufacturer);
                stm.setString(5, category);
                stm.setInt(6, condition);
                stm.setString(7, imgLink);
                stm.setInt(8, ID);
            
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

    public boolean InsertProduct(String proName, String description , float price, int stock, String manufacturer, String category, int condition, String imgLink)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "Insert INTO tblProduct(productName, description, price, stock, manufacturer, category, condition, imgLink) "
                        + "Values(?, ?, ?, ?, ?, ?, ?, ?) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, proName);
                stm.setString(2, description);
                stm.setFloat(3, price);
                stm.setInt(4, stock);
                stm.setString(5, manufacturer);
                stm.setString(6, category);
                stm.setInt(7, condition);
                stm.setString(8, imgLink);              

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
 
    public ProductDTO getProductInfo(int ID, String proName,  String description, String manufacturer, String category, int stock, String imgLink) throws SQLException, NamingException {
       
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "SELECT proName, description, manufacturer, category, stock, price "
                        + "FROM tblProduct "
                        + "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ID);

                rs = stm.executeQuery();
                if(rs.next()) {
                    proName = rs.getString("proName");
                    description = rs.getString("description");
                    manufacturer  = rs.getString("manufacturer");
                    category = rs.getString("category");
                    stock = rs.getInt("stock");
                    imgLink = rs.getString("imgLink");
                    float price = rs.getFloat("price");
                    int condition = rs.getInt("condition");
                    
                    ProductDTO dto =  new ProductDTO(ID, proName, description, price, stock, manufacturer, category, condition, imgLink);
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
    
    public int getProductRemaining(int ID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "SELECT stock "
                        + "FROM tblProduct "
                        + "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ID);

                rs = stm.executeQuery();
                if(rs.next()) {
                    int remaining = rs.getInt("stock");
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
                String sql = "Select ID, proName, description, price, stock, manufacturer, category, condition,imgLink "
                        + "From tblProduct ";
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                      int ID = rs.getInt("ID");
                      String proName = rs.getString("proName");
                      String description = rs.getString("description");
                      float price = rs.getFloat("price");
                      int stock = rs.getInt("stock");
                      String manufacturer = rs.getString("manufacturer");
                      String category = rs.getString("category");
                      int condition = rs.getInt("condition");
                      String imgLink = rs.getString("imgLink");
                      ProductDTO dto = new ProductDTO(ID, proName, description, price, stock, manufacturer, category, condition, imgLink);
                      if (this.productList == null){
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
    
    public boolean IsProductNametaken(String proName) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. connect DB
            con = DBIHelper.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "Select proName "
                        + "From tblProduct "
                        + "Where proName like ?";

                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, proName);
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
    
    //Add function: Nguyen Tien Dung SE150614
    public ProductDTO showByID(int productID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductDTO dto = null;
        try {
            con = DBIHelper.getConnection();
            if (con != null) {
                String sql = "Select proName, description, price, stock, manufacturer, category, condition,imgLink  "
                        + "From tblProducts "  + "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, productID);
                
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productName = rs.getString("proName");
                    String description = rs.getString("description");
                    int price = rs.getInt("price");
                    int stock = rs.getInt("stock");
                    String manufacturer = rs.getString("manufacturer");
                    String category = rs.getString("category");
                    int condition = rs.getInt("condition");
                    String img = rs.getString("imgLink");

                    dto = new ProductDTO(productID, productName, description, price, stock, manufacturer,category, condition, img);
                    //this.productList.add(dto);
                }
                return dto;
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
}
