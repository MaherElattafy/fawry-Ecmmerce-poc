package products;

public abstract class Product {
    public String name;
    public double price;
    public int quantity;
    Product(String name,double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public boolean isExpire(){
        return false;
    }
    boolean Shippable(){
        return this instanceof Shippable;
    }
}
