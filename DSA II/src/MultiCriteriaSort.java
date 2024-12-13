// MultiCriteriaSort Class
import java.util.ArrayList;
class MultiCriteriaSort {
    public static void sortByCategoryAndPrice(ArrayList<InventoryItem> items) {
        items.sort((item1, item2) -> {
            int categoryComparison = item1.getCategory().compareTo(item2.getCategory());
            if (categoryComparison == 0) {
                return Double.compare(item2.getPrice(), item1.getPrice()); // Descending price
            }
            return categoryComparison; // Ascending category
        });
    }
}