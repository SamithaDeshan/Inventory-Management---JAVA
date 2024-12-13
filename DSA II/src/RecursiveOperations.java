// Recursive Operations Class
import java.util.ArrayList;
class RecursiveOperations {
    // Recursive Binary Search for ProductID
    public static InventoryItem searchByProductID(ArrayList<InventoryItem> items, String productID, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        InventoryItem midItem = items.get(mid);
        int comparison = midItem.getProductID().compareTo(productID);
        if (comparison == 0) {
            return midItem;
        } else if (comparison < 0) {
            return searchByProductID(items, productID, mid + 1, high);
        } else {
            return searchByProductID(items, productID, low, mid - 1);
        }
    }

    // Recursive Category Count
    public static int countByCategory(ArrayList<InventoryItem> items, String category, int index) {
        if (index >= items.size()) {
            return 0;
        }
        int count = items.get(index).getCategory().equals(category) ? 1 : 0;
        return count + countByCategory(items, category, index + 1);
    }

    // Recursive Price Calculation
    public static double calculateTotalPrice(ArrayList<InventoryItem> items, int index) {
        if (index >= items.size()) {
            return 0.0;
        }
        return items.get(index).getPrice() * items.get(index).getQuantity() + calculateTotalPrice(items, index + 1);
    }
}