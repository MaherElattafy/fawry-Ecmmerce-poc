package Shipping;

import cart.Cart;
import cart.CartItem;
import customer.Customer;

public class ShippingService {
    public void checkout(Cart cart , Customer customer) throws Exception {
        if (cart.isEmpty()) throw new Exception("basket is empty");
        if (cart.ExpiredoutStock()) throw new Exception("Expired products");

        double subtotal = cart.getSubtotal();
        double shipping = cart.getShippableItems().isEmpty() ? 0 : cart.getShippingfee();
        double total = subtotal + shipping;
        double customerBalance = customer.getBalance();
        if ( customerBalance < total) throw new Exception("Insufficient balance");

        if (cart.getShippableItems().isEmpty()) {
            System.out.println("Shipment notice");
            for (Shippable shp : cart.getShippableItems()) {
                System.out.printf("ship" + shp.getName() + "weight" + shp.getWeight() + "kg");
            }

            System.out.printf( "shipping fee:%.2f\n",shipping);

        }
        System.out.println("checkout receipt");
        for (CartItem item : cart.items){
            System.out.printf("%dx %s =%.2f\n",item.quantity,item.product.name,item.getTotalPrice());
            item.product.quantity -= item.quantity;
        }
        System.out.println("---------------");
        System.out.printf("subtotal:%.2f\n" ,subtotal);
        System.out.printf("shipping:%.2f\n",shipping);
        System.out.printf("Total paid:%.2f\n",total);
        customerBalance -= total;
        customer.setBalance(customerBalance);

    }
}
