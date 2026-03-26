package Part_1;

import java.util.*;

class merge {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(ArrayList<Integer> arr, int l, int m, int r) {

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
    }

    // Main function that sorts arr[l..r] using Part_1.merge()
    static void mergeSort(ArrayList<Integer> arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // Convenience method to sort the entire ArrayList
    static void mergeSort(ArrayList<Integer> arr) {
        mergeSort(arr, 0, arr.size() - 1);
    }

    // Convenience method to print the ArrayList
    static void printArray(ArrayList<Integer> arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}