package Part_1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class P1_Func {


    //function for randomized set size
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

    //function for user inputted  set size
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

    //measures how long algorithm took
    public static double measureTime(Runnable sortingMethod){
        long startTime = System.currentTimeMillis();
        sortingMethod.run();
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static void printSortingTime(String algorithmName, double time){
        System.out.println(algorithmName + " took: " + time + "ms");
    }

    //prints algorithm statistics
    public static void SortingAlgos(ArrayList<Integer> Input){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> unsortedSet = Input;

        selection sel = new selection();
        merge mer = new merge();
        radix rad = new radix();

        System.out.println("\nTest Results");
        System.out.println("Sample Size: " + unsortedSet.size() + "\n");

        //selectionsort
        ArrayList<Integer> selectionCopy = new ArrayList<>(Input);
        double stime = measureTime(() -> sel.selectionSort(new ArrayList<>(Input)));
        double selectionComparisons = selection.selectionSort(selectionCopy);
        printSortingTime("Selection Sort", stime);
        System.out.println("Comparisons: " + selectionComparisons + "\n");

        //mergesort
        ArrayList<Integer> mergeCopy = new ArrayList<>(Input);
        double mtime = measureTime(() -> mer.mergeSort(new ArrayList<>(Input)));
        int mergeComparisons = merge.mergeSort(mergeCopy);
        printSortingTime("Merge Sort", mtime);
        System.out.println("Comparisons: " + mergeComparisons + "\n");

        //radixsort
        ArrayList<Integer> radixCopy = new ArrayList<>(Input);
        double rtime = measureTime(() -> rad.radixsort(new ArrayList<>(Input),Input.size()));
        int radixComparisons = radix.radixsort(radixCopy, radixCopy.size());
        printSortingTime("Radix Sort", rtime);
        System.out.println("Comparisons: " + radixComparisons);

        //print sorted set check
        while (true) {
            String loopinput = null;
            String loopChoice = null;

            System.out.print("\nPrint the sorted Set? Y/N: ");

            try {
                loopinput = scanner.next();
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Input type invalid!");
            }

            loopChoice = loopinput.toUpperCase();
            if (loopChoice.equals("Y")){
                System.out.println(radixCopy);
                return;
            } else if (loopChoice.equals("N")) {
                return;
            } else {
                System.out.println("unidentified response");
            }
        }
    }
}



