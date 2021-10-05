/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.tblUsers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import phucnt.ultils.DBIHelper;

/**
 *
 * @author PC
 */
public class UserDAO implements Serializable{
    public UserDTO checkLogin(String userID, String password) 
            throws SQLException, NamingException{
        
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con = DBIHelper.getConnection();
            if(con != null){
                String sql = "Select fullName, roleID "
                        + "From tblUsers "
                        + "Where userID = ? AND password = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    UserDTO user = new UserDTO(userID, password, fullName, 0, "", roleID);
                    return user;
                }
            }
            
        } finally{
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

    public boolean newRegister(String username, String password, String fullname,
            int phone, String address, String role)
        throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            //1. Make connection.
            con = DBIHelper.getConnection();
            if (con != null) {
                //2.Create SQL String.
                String sql = "Insert Into "
                            + "tblUsers(userID,password,fullName,phone,address,roleID) "
                            + "Values ( ?, ?, ?, ?, ?, ?)";
                
                //3. Create Statement and assign Parameter(s) if any.
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullname);
                stm.setInt(4, phone);
                stm.setString(5, address);
                stm.setString(6, role);
                //4. Execute Query.
                int row = stm.executeUpdate();
                
                //5. Process resultSet.
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
}
