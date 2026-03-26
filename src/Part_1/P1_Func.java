package Part_1;

import java.util.ArrayList;

class P1_Func {


    public static ArrayList<Integer> randomSet() {
        ArrayList<Integer> set= new ArrayList<>();

        //randomized size
        int setSize = (int) (Math.random() * (100001 - 5) + 5);

        //randomized values
        for (int i = 0; i <=setSize; i++){
            set.add((int) (Math.random() * (100001 - 1)) + 1);
        }

        //return for use in main
        return set;
    }

    public static ArrayList<Integer> inputSet(int size) {
        ArrayList<Integer> set= new ArrayList<>();

        //randomized size
        int setSize = size-1;

        //randomized values
        for (int i = 0; i <=setSize; i++){
            set.add((int) (Math.random() * ((size + 1) - 1)) + 1);
        }

        //return for use in main
        return set;
    }

    public static double measureTime(Runnable sortingMethod){
        long startTime = System.currentTimeMillis();
        sortingMethod.run();
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static void printSortingTime(String algorithmName, double time){
        System.out.println(algorithmName + " took: " + time + "ms");
    }

    public static void SortingAlgos(ArrayList<Integer> Input){
        ArrayList<Integer> unsortedSet = Input;

        selection sel = new selection();
        merge mer = new merge();
        radix rad = new radix();

        System.out.println("\nTest Results");
        System.out.println("Sample Size: " + unsortedSet.size());
        double stime = measureTime(() -> sel.selectionSort(new ArrayList<>(Input)));
        printSortingTime("Selection Sort", stime);

        //mergesort
        double mtime = measureTime(() -> mer.mergeSort(new ArrayList<>(Input)));
        printSortingTime("Merge Sort", mtime);

        //radixsort
        double rtime = measureTime(() -> rad.radixsort(new ArrayList<>(Input),Input.size()));
        printSortingTime("Radix Sort", rtime);
    }
}



