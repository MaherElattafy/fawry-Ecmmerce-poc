import Shipping.ShippingService;
import cart.Cart;
import customer.Customer;
import products.Biscuits;
import products.Cheese;
import products.MobileScratchCard;
import products.Tv;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Cheese cheese = new Cheese("cheese", 100, 6, LocalDate.of(2025, 9, 2), 0.5);
            Biscuits biscuits = new Biscuits("Biscuits",120,3,LocalDate.of(2025,8,1),0.2);
            Tv tv =new Tv("samsung Tv",4000,3,9.0);
            MobileScratchCard scratch = new MobileScratchCard("scratch",40,12);
            Customer customer = new Customer("Ali",10000);
            Cart cart = new Cart();

            cart.add(cheese,3);
            cart.add(biscuits,1);

            cart.add(tv,1);
            cart.add(scratch,3);

            ShippingService shippingService = new ShippingService();
            shippingService.checkout(cart , customer);

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
