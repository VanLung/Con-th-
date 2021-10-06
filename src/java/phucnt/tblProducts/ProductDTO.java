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
public class ProductDTO implements Serializable{
   private int ID;
    private String proName;
    private String description;
    private float price;
    private int stock;
    private String manufacturer;
    private String category;
    private int condition;
    private String imgLink;

    public ProductDTO() {
    }

    public ProductDTO(int ID, String proName, String description, float price, int stock, String manufacturer, String category, int condition, String imgLink) {
        this.ID = ID;
        this.proName = proName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.manufacturer = manufacturer;
        this.category = category;
        this.condition = condition;
        this.imgLink = imgLink;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
    
    
}
