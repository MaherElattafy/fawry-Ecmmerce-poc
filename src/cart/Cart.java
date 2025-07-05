package cart;
import Shipping.Shippable;
import products.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) throws Exception {
        if (quantity > product.quantity )
            throw new Exception("Quantity not available");
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public double getShippingfee() {
        double totalWeight = 0;
        for (CartItem item : items) {
            totalWeight += item.getTotalWeight();
        }
        return totalWeight * 8;
    }

    public boolean ExpiredoutStock() {
        for (CartItem item : items) {
            if (item.product.isExpire()) {
                return true;
            }
        }
        return false;

    }

     public List<Shippable> getShippableItems(){
        List<Shippable> list = new ArrayList<>();
        for (CartItem item : items) {
            if (item.product instanceof Shippable) {
                list.add((Shippable) item.product);
            }
        }
        return list;
    }
}


