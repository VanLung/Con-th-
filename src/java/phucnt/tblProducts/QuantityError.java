/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.tblProducts;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class QuantityError implements Serializable{
    private String enterQuantityError;
    private String editQuantityError;

    public QuantityError() {
    }

    public QuantityError(String enterQuantityError, String editQuantityError) {
        this.enterQuantityError = enterQuantityError;
        this.editQuantityError = editQuantityError;
    }

    /**
     * @return the enterQuantityError
     */
    public String getEnterQuantityError() {
        return enterQuantityError;
    }

    /**
     * @param enterQuantityError the enterQuantityError to set
     */
    public void setEnterQuantityError(String enterQuantityError) {
        this.enterQuantityError = enterQuantityError;
    }

    /**
     * @return the editQuantityError
     */
    public String getEditQuantityError() {
        return editQuantityError;
    }

    /**
     * @param editQuantityError the editQuantityError to set
     */
    public void setEditQuantityError(String editQuantityError) {
        this.editQuantityError = editQuantityError;
    }
    
    
}
