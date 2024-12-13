// Inventory Management Class
import java.util.Scanner;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<InventoryItem> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        if (item.getProductID() == null || item.getProductID().isEmpty()) {
            System.out.println("Error: ProductID cannot be empty.");
            return;
        }
        if (item.getName() == null || item.getName().isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }
        if (item.getPrice() < 0) {
            System.out.println("Error: Price cannot be negative.");
            return;
        }
        if (item.getQuantity() < 0) {
            System.out.println("Error: Quantity cannot be negative.");
            return;
        }
        items.add(item);
        System.out.println("Item added successfully.");
    }

    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (InventoryItem item : items) {
                System.out.println(item);
            }
        }
    }

    public void quickSortByPrice() {
        QuickSort.sortByPrice(items);
        System.out.println("Items sorted by price in descending order.");
    }

    public void mergeSortByName() {
        MergeSort.sortByName(items);
        System.out.println("Items sorted by name in alphabetical order.");
    }

    public void shellSortByQuantity() {
        ShellSort.sortByQuantity(items);
        System.out.println("Items sorted by quantity in ascending order.");
    }

    public void multiCriteriaSortByCategoryAndPrice() {
        MultiCriteriaSort.sortByCategoryAndPrice(items);
        System.out.println("Items sorted by category (ascending) and price (descending).");
    }

    public void searchProductByID(String productID) {
        if (productID == null || productID.isEmpty()) {
            System.out.println("Error: ProductID cannot be empty.");
            return;
        }
        InventoryItem result = RecursiveOperations.searchByProductID(items, productID, 0, items.size() - 1);
        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product with ID " + productID + " not found.");
        }
    }

    public void countProductsByCategory(String category) {
        if (category == null || category.isEmpty()) {
            System.out.println("Error: Category cannot be empty.");
            return;
        }
        int count = RecursiveOperations.countByCategory(items, category, 0);
        System.out.println("Total products in category '" + category + "': " + count);
    }

    public void calculateTotalInventoryValue() {
        double totalValue = RecursiveOperations.calculateTotalPrice(items, 0);
        System.out.println("Total inventory value: " + totalValue);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Quick Sort by Price");
            System.out.println("4. Merge Sort by Name");
            System.out.println("5. Shell Sort by Quantity");
            System.out.println("6. Multi-Criteria Sort by Category and Price");
            System.out.println("7. Search Product by ID");
            System.out.println("8. Count Products by Category");
            System.out.println("9. Calculate Total Inventory Value");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ProductID: ");
                    String productID = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();

                    InventoryItem newItem = new InventoryItem(productID, name, price, quantity, category);
                    inventory.addItem(newItem);
                    break;

                case 2:
                    inventory.viewItems();
                    break;

                case 3:
                    inventory.quickSortByPrice();
                    break;

                case 4:
                    inventory.mergeSortByName();
                    break;

                case 5:
                    inventory.shellSortByQuantity();
                    break;

                case 6:
                    inventory.multiCriteriaSortByCategoryAndPrice();
                    break;

                case 7:
                    System.out.print("Enter ProductID to search: ");
                    String searchID = scanner.nextLine();
                    inventory.searchProductByID(searchID);
                    break;

                case 8:
                    System.out.print("Enter category to count: ");
                    String countCategory = scanner.nextLine();
                    inventory.countProductsByCategory(countCategory);
                    break;

                case 9:
                    inventory.calculateTotalInventoryValue();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}