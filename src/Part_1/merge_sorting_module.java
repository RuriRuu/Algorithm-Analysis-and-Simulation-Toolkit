package Part_1;

import java.util.*;

class merge_sorting_module {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static int merge(ArrayList<Integer> arr, int l, int m, int r) {
        int comparisonCount = 0;

        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        ArrayList<Integer> L = new ArrayList<>(n1);
        ArrayList<Integer> R = new ArrayList<>(n2);

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L.add(arr.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.add(arr.get(m + 1 + j));

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            comparisonCount++; // Count this comparison
            if (L.get(i) <= R.get(j)) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }

        return comparisonCount;
    }

    // Main function that sorts arr[l..r] using Part_1.merge()
    static int mergeSort(ArrayList<Integer> arr, int l, int r) {
        int totalComparisons = 0;

        if (l < r) {
            int m = l + (r - l) / 2;
            totalComparisons += mergeSort(arr, l, m);
            totalComparisons += mergeSort(arr, m + 1, r);
            totalComparisons += merge(arr, l, m, r);
        }

        return totalComparisons;
    }

    // Convenience method to sort the entire ArrayList
    static int mergeSort(ArrayList<Integer> arr) {
        return mergeSort(arr, 0, arr.size() - 1);
    }

    // Convenience method to print the ArrayList
    static void printArray(ArrayList<Integer> arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}