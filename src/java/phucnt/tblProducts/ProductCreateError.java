package phucnt.tblProducts;

import java.io.Serializable;

public class ProductCreateError implements Serializable {

    private String proNameLengthErr;
    private String descriptionLengthErr;
    private String priceFormatErr;
    private String stockFormatErr;
    private String manufacturerLengthErr;
    private String categoryLengthErr;
    private String imgLengthErr;

    public ProductCreateError() {
        this.proNameLengthErr = "";
        this.descriptionLengthErr = "";
        this.priceFormatErr = "";
        this.stockFormatErr = "";
        this.manufacturerLengthErr = "";
        this.categoryLengthErr = "";
        this.imgLengthErr = "";
    }

    public String getProNameLengthErr() {
        return proNameLengthErr;
    }

    public void setProNameLengthErr(String proNameLengthErr) {
        this.proNameLengthErr = proNameLengthErr;
    }

    public String getDescriptionLengthErr() {
        return descriptionLengthErr;
    }

    public void setDescriptionLengthErr(String descriptionLengthErr) {
        this.descriptionLengthErr = descriptionLengthErr;
    }

    public String getPriceFormatErr() {
        return priceFormatErr;
    }

    public void setPriceFormatErr(String priceFormatErr) {
        this.priceFormatErr = priceFormatErr;
    }

    public String getStockFormatErr() {
        return stockFormatErr;
    }

    public void setStockFormatErr(String stockFormatErr) {
        this.stockFormatErr = stockFormatErr;
    }

    public String getManufacturerLengthErr() {
        return manufacturerLengthErr;
    }

    public void setManufacturerLengthErr(String manufacturerLengthErr) {
        this.manufacturerLengthErr = manufacturerLengthErr;
    }

    public String getCategoryLengthErr() {
        return categoryLengthErr;
    }

    public void setCategoryLengthErr(String categoryLengthErr) {
        this.categoryLengthErr = categoryLengthErr;
    }

    public String getImgLengthErr() {
        return imgLengthErr;
    }

    public void setImgLengthErr(String imgLengthErr) {
        this.imgLengthErr = imgLengthErr;
    }

    @Override
    public String toString() {
        return proNameLengthErr + descriptionLengthErr + priceFormatErr
                + stockFormatErr + manufacturerLengthErr + categoryLengthErr
                + imgLengthErr;
    }

}
