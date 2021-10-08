/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb.tblUsers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import mb.ultils.DBIHelper;

/**
 *
 * @author PC
 */
public class UserDAO implements Serializable{
    public UserDTO checkLogin(String userName, String password) throws SQLException {
         Connection con = null;
         PreparedStatement stm = null;
         ResultSet rs = null;
        try {
            con =mb.ultils.DBIHelper.getConnection();
            if (con != null) {
                String sql = "SELECT UserID, UserName "
                        + "FROM tblUser "
                        + "WHERE userName = ? AND password = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, userName);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    UserDTO u = new UserDTO(rs.getInt("UserID"), rs.getString("UserName"), "****");
                    return u;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
