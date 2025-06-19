import java.util.*;

class Order {
    String orderId;
    String customerName;
    double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "[" + orderId + " - " + customerName + " - $" + totalPrice + "]";
    }
}

public class OrderSorting {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Alice", 1200.50),
            new Order("O002", "Bob", 450.00),
            new Order("O003", "Charlie", 980.75),
            new Order("O004", "Diana", 2300.00),
            new Order("O005", "Ethan", 199.99)
        };

        Order[] bubbleSorted = Arrays.copyOf(orders, orders.length);
        bubbleSort(bubbleSorted);
        System.out.println("Orders sorted by Bubble Sort:");
        displayOrders(bubbleSorted);

        Order[] quickSorted = Arrays.copyOf(orders, orders.length);
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        displayOrders(quickSorted);
    }
}
