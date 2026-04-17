import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Product {
    String name;
    double price;
    boolean inStock;

    
    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    
    @Override
    public String toString() {
        return String.format("Product: %-15s | Price: $%6.2f | In Stock: %b", 
                             name, price, inStock);
    }

    
    public static void main(String[] args) {
        
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 999.99, true));
        products.add(new Product("Mouse", 25.50, true));      
        products.add(new Product("Keyboard", 45.00, false));  
        products.add(new Product("Cables", 12.00, true));     
        products.add(new Product("Monitor", 150.00, true));   

        
        Predicate<Product> isAffordable = p -> p.price < 50 && p.inStock;

        
        products.removeIf(isAffordable.negate());

        
        System.out.println("--- Affordable & Available Items ---");
        products.forEach(p -> System.out.println(p));
    }
}