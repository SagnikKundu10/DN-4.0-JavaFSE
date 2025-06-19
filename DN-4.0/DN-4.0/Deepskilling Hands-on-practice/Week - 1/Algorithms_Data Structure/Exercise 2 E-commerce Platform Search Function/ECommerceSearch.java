import java.util.Arrays;
import java.util.Comparator;

class Product {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + " - " + productName + " - " + category + "]";
    }
}

public class ECommerceSearch {

    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(name);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Mouse", "Electronics"),
            new Product("P002", "Shirt", "Clothing"),
            new Product("P003", "Keyboard", "Electronics"),
            new Product("P004", "Book", "Books"),
            new Product("P005", "Monitor", "Electronics")
        };

        System.out.println("Linear Search Result:");
        Product result1 = linearSearch(products, "Keyboard");
        System.out.println(result1 != null ? result1 : "Product not found");

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\nBinary Search Result:");
        Product result2 = binarySearch(products, "Keyboard");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
