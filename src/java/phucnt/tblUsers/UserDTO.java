/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.tblUsers;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class UserDTO implements Serializable{
    private String userID;
    private String password;
    private String fullName;
    private int phone;
    private String address;
    private String roleID;

    public UserDTO() {
    }

    public UserDTO(String userID, String password, String fullName, int phone, String address, String roleID) {
        this.userID = userID;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.roleID = roleID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }
    
    
}
