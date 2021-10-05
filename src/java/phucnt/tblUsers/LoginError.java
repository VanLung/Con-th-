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
public class LoginError implements Serializable{
    private String loginInfoNotMatch;

    public LoginError() {
    }

    public LoginError(String loginInfoNotMatch) {
        this.loginInfoNotMatch = loginInfoNotMatch;
    }

    /**
     * @return the loginInfoNotMatch
     */
    public String getLoginInfoNotMatch() {
        return loginInfoNotMatch;
    }

    /**
     * @param loginInfoNotMatch the loginInfoNotMatch to set
     */
    public void setLoginInfoNotMatch(String loginInfoNotMatch) {
        this.loginInfoNotMatch = loginInfoNotMatch;
    }
    
    
}
