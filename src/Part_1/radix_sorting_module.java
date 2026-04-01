package Part_1;// Part_1.radix sort Java implementation with ArrayList
import java.util.*;

class radix_sorting_module {

    // A utility function to get maximum value in arr[]
    static int getMax(ArrayList<Integer> arr, int n)
    {
        int comparisonCount = 0;
        int mx = arr.get(0);
        for (int i = 1; i < n; i++) {
            comparisonCount++; // Count this comparison
            if (arr.get(i) > mx)
                mx = arr.get(i);
        }
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(ArrayList<Integer> arr, int n, int exp)
    {
        ArrayList<Integer> output = new ArrayList<>(Collections.nCopies(n, 0));
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr.get(i) / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output.set(count[(arr.get(i) / exp) % 10] - 1, arr.get(i));
            count[(arr.get(i) / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            arr.set(i, output.get(i));
    }

    // The main function to that sorts arr[] of
    // size n using Part_1.radix Sort
    // Returns the total number of comparisons
    static int radixsort(ArrayList<Integer> arr, int n)
    {
        int totalComparisons = 0;

        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
        totalComparisons += n - 1; // Add comparisons from getMax

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
            // Radix sort doesn't do comparisons in the traditional sense
            // The comparisons happen in getMax only
        }

        return totalComparisons;
    }

    // A utility function to print an array
    static void print(ArrayList<Integer> arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }
}