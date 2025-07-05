package products;

import java.time.LocalDate;

public class ExpirableProduct extends Product{
  public LocalDate expiryDate;
  public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }
    @Override
    public boolean isExpire(){
        return LocalDate.now().isAfter(expiryDate);

    }
}
