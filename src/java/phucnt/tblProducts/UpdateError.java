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
public class UpdateError implements Serializable{
    private String updatePriceError;
    private String updateQuantityError;
    private String updateCategoryIDError;

    public UpdateError() {
    }

    /**
     * @return the updatePriceError
     */
    public String getUpdatePriceError() {
        return updatePriceError;
    }

    /**
     * @param updatePriceError the updatePriceError to set
     */
    public void setUpdatePriceError(String updatePriceError) {
        this.updatePriceError = updatePriceError;
    }

    /**
     * @return the updateQuantityError
     */
    public String getUpdateQuantityError() {
        return updateQuantityError;
    }

    /**
     * @param updateQuantityError the updateQuantityError to set
     */
    public void setUpdateQuantityError(String updateQuantityError) {
        this.updateQuantityError = updateQuantityError;
    }

    /**
     * @return the updateCategoryIDError
     */
    public String getUpdateCategoryIDError() {
        return updateCategoryIDError;
    }

    /**
     * @param updateCategoryIDError the updateCategoryIDError to set
     */
    public void setUpdateCategoryIDError(String updateCategoryIDError) {
        this.updateCategoryIDError = updateCategoryIDError;
    }
    
    
}
