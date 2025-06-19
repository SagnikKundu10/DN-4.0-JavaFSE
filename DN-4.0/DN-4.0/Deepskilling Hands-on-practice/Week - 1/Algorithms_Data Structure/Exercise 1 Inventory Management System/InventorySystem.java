import java.util.*;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + productId + " - " + productName + ", Qty: " + quantity + ", Price: " + price + "]";
    }
}

public class InventorySystem {
    private Map<String, Product> inventory;

    public InventorySystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.quantity = quantity;
            p.price = price;
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.remove(productId) == null) {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();

        system.addProduct(new Product("P001", "Mouse", 50, 299.99));
        system.addProduct(new Product("P002", "Keyboard", 30, 499.50));
        system.addProduct(new Product("P003", "Monitor", 10, 8499.00));

        System.out.println("\nInitial Inventory:");
        system.displayInventory();

        system.updateProduct("P002", 25, 479.00);
        System.out.println("\nInventory after update:");
        system.displayInventory();

        system.deleteProduct("P001");
        System.out.println("\nInventory after deletion:");
        system.displayInventory();
    }
}
