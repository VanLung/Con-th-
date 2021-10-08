/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb.tblUsers;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class UserDTO implements Serializable{
    private int userID;
    private String password;
    private String fullName;

    public UserDTO() {
    }

    
    
    public UserDTO(int userID, String password, String fullName) {
        this.userID = userID;
        this.password = password;
        this.fullName = fullName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
}
