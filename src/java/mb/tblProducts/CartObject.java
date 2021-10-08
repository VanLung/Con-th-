package mb.tblProducts;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CartObject implements Serializable {

    private Map<ProductDTO, Integer> items;
    private float grandTotal;

    public CartObject() {
    }

    public Map<ProductDTO, Integer> getItems() {
        return items;
    }
    
    public void clearCart() {
        this.items = null;
    }

    public float getGrandTotal() {
        grandTotal = 0;
        Set<ProductDTO> products = items.keySet();
        for (ProductDTO product : products) {
            Integer quantity = items.get(product);
            if (quantity != null) {
                grandTotal += quantity * product.getPrice();
            }
        }
        return grandTotal;
    }

    public void addPhone(ProductDTO product) {
        // 1. If cart is empty, initialize
        if (this.items == null) {
            items = new HashMap<ProductDTO, Integer>();
        }

        // 2. Check if product is already in cart, increase quantity (value)
        boolean isExist = false;
        Set<ProductDTO> products = this.items.keySet();
        for (ProductDTO pro : products) {
            if (pro.getID() == product.getID()) {
                this.items.put(pro, this.items.get(pro) + 1);
                isExist = true;
            }
        }

        // 3. Product is not in cart, add to cart normally
        if (!isExist) {
            this.items.put(product, 1);
        }
    }

    public void deletePhone(int productID) {
        // 1. If cart is empty, do nothing
        if (this.items == null) {
            return;
        }

        // 2. If cart has product
        Set<ProductDTO> products = this.items.keySet();
        for (ProductDTO pro : products) {
            if (pro.getID() == productID) {
                this.items.remove(pro);
                break;
            }
        }

        // 3. Check if cart is empty, remove cart
        if (this.items.size() == 0) {
            this.items = null;
        }
    }
}
