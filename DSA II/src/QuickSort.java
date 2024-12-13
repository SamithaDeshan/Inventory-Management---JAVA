// QuickSort Class
import java.util.ArrayList;

class QuickSort {
    public static void sortByPrice(ArrayList<InventoryItem> items) {
        quickSort(items, 0, items.size() - 1);
    }

    private static void quickSort(ArrayList<InventoryItem> items, int low, int high) {
        if (low < high) {
            int pi = partition(items, low, high);
            quickSort(items, low, pi - 1);
            quickSort(items, pi + 1, high);
        }
    }

    private static int partition(ArrayList<InventoryItem> items, int low, int high) {
        double pivot = items.get(high).getPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (items.get(j).getPrice() > pivot) {
                i++;
                InventoryItem temp = items.get(i);
                items.set(i, items.get(j));
                items.set(j, temp);
            }
        }
        InventoryItem temp = items.get(i + 1);
        items.set(i + 1, items.get(high));
        items.set(high, temp);
        return i + 1;
    }
}