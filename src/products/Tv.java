package products;

public class Tv extends Product implements Shippable{
   private double weight;
   public Tv(String name, double price, int quantity,double weight) {
        super(name, price, quantity);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
