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
    private Map<Integer, ProductDTO> items;

    public Map<Integer, ProductDTO> getItems() {
        return items;
    }

    public void addPhone(ProductDTO product){
        //int totalQuantity;
        if(this.items == null){
            items = new HashMap<>();
        }
            
//        if(this.items.containsKey(product.getID())){
//            this.items.get(product.getID()).setQuantity(product.getQuantity() + 1);
//        }
//        } else{
//            totalQuantity = quantity;
//        }
//        
        this.items.put(product.getID(), product);
    }
    
    public void deletePhone(int productID){
        if(this.items == null){
            return;
        }
        
        if(this.items.containsKey(productID)){
            this.items.remove(productID);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
    
//    public void updateFlower(String producID, int quantity){
//        if(this.items == null){
//            return;
//        }
//        if(this.items.containsKey(producID)){
//            this.items.replace(producID, quantity);
//        }
//    }
}
