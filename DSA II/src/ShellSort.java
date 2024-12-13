// ShellSort Class
import java.util.ArrayList;
class ShellSort {
    public static void sortByQuantity(ArrayList<InventoryItem> items) {
        int n = items.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                InventoryItem temp = items.get(i);
                int j;
                for (j = i; j >= gap && items.get(j - gap).getQuantity() > temp.getQuantity(); j -= gap) {
                    items.set(j, items.get(j - gap));
                }
                items.set(j, temp);
            }
        }
    }
}
