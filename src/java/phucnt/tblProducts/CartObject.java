/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.tblProducts;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class CartObject implements Serializable{
    //    Map<productID, quantity>
    private Map<String, Integer> items;

    public Map<String, Integer> getItems() {
        return items;
    }

    public void addFlower(String productID, int quantity){
        int totalQuantity;
        if(this.items == null){
            items = new HashMap<>();
        }
            
        if(this.items.containsKey(productID)){
            totalQuantity = this.items.get(productID) + quantity;
        } else{
            totalQuantity = quantity;
        }
        
        this.items.put(productID, totalQuantity);
    }
    
    public void deleteFlower(String productID){
        if(this.items == null){
            return;
        }
        
        if(this.items.containsKey(productID)){
            this.items.remove(productID);
        }
    }
    
    public void updateFlower(String producID, int quantity){
        if(this.items == null){
            return;
        }
        if(this.items.containsKey(producID)){
            this.items.replace(producID, quantity);
        }
    }
}
