package cart;

import products.Product;
import products.Shippable;

public class CartItem {
    public Product product;
    public int quantity;
    CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;

    }
    public double getTotalPrice(){
        return product.price* quantity;
    }
   public double getTotalWeight(){
        if (product instanceof Shippable){
            return ((products.Shippable)product).getWeight()*quantity;
        }
        return 0;
    }
}

