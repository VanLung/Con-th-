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
public class CreateError implements Serializable {

    private String productIDLengthError;
    private String productNameLengthError;
    private String quantitySizeError;
    private String priceSizeError;
    private String categoryIDLengthError;
    private String productIDisExisted;
    private String productNameisExisted;

    public CreateError() {
    }

    public CreateError(String productIDLengthError, String productNameLengthError, String quantitySizeError, String priceSizeError, String categoryIDLengthError, String productIDisExisted, String productNameisExisted) {
        this.productIDLengthError = productIDLengthError;
        this.productNameLengthError = productNameLengthError;
        this.quantitySizeError = quantitySizeError;
        this.priceSizeError = priceSizeError;
        this.categoryIDLengthError = categoryIDLengthError;
        this.productIDisExisted = productIDisExisted;
        this.productNameisExisted = productNameisExisted;
    }

    /**
     * @return the productIDLengthError
     */
    public String getProductIDLengthError() {
        return productIDLengthError;
    }

    /**
     * @param productIDLengthError the productIDLengthError to set
     */
    public void setProductIDLengthError(String productIDLengthError) {
        this.productIDLengthError = productIDLengthError;
    }

    /**
     * @return the productNameLengthError
     */
    public String getProductNameLengthError() {
        return productNameLengthError;
    }

    /**
     * @param productNameLengthError the productNameLengthError to set
     */
    public void setProductNameLengthError(String productNameLengthError) {
        this.productNameLengthError = productNameLengthError;
    }

    /**
     * @return the quantitySizeError
     */
    public String getQuantitySizeError() {
        return quantitySizeError;
    }

    /**
     * @param quantitySizeError the quantitySizeError to set
     */
    public void setQuantitySizeError(String quantitySizeError) {
        this.quantitySizeError = quantitySizeError;
    }

    /**
     * @return the priceSizeError
     */
    public String getPriceSizeError() {
        return priceSizeError;
    }

    /**
     * @param priceSizeError the priceSizeError to set
     */
    public void setPriceSizeError(String priceSizeError) {
        this.priceSizeError = priceSizeError;
    }

    /**
     * @return the categoryIDLengthError
     */
    public String getCategoryIDLengthError() {
        return categoryIDLengthError;
    }

    /**
     * @param categoryIDLengthError the categoryIDLengthError to set
     */
    public void setCategoryIDLengthError(String categoryIDLengthError) {
        this.categoryIDLengthError = categoryIDLengthError;
    }

    /**
     * @return the productIDisExisted
     */
    public String getProductIDisExisted() {
        return productIDisExisted;
    }

    /**
     * @param productIDisExisted the productIDisExisted to set
     */
    public void setProductIDisExisted(String productIDisExisted) {
        this.productIDisExisted = productIDisExisted;
    }

    /**
     * @return the productNameisExisted
     */
    public String getProductNameisExisted() {
        return productNameisExisted;
    }

    /**
     * @param productNameisExisted the productNameisExisted to set
     */
    public void setProductNameisExisted(String productNameisExisted) {
        this.productNameisExisted = productNameisExisted;
    }
    
    

}
