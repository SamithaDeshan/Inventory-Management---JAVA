// MergeSort Class
import java.util.ArrayList;
class MergeSort {
    public static void sortByName(ArrayList<InventoryItem> items) {
        mergeSort(items, 0, items.size() - 1);
    }

    private static void mergeSort(ArrayList<InventoryItem> items, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(items, left, mid);
            mergeSort(items, mid + 1, right);
            merge(items, left, mid, right);
        }
    }

    private static void merge(ArrayList<InventoryItem> items, int left, int mid, int right) {
        ArrayList<InventoryItem> temp = new ArrayList<>();
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (items.get(i).getName().compareTo(items.get(j).getName()) <= 0) {
                temp.add(items.get(i++));
            } else {
                temp.add(items.get(j++));
            }
        }
        while (i <= mid) temp.add(items.get(i++));
        while (j <= right) temp.add(items.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            items.set(left + k, temp.get(k));
        }
    }
}
