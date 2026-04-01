package Part_1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Part1_Main_Module {


    public void Menu (){
        Part1_Functions func = new Part1_Functions();
        Scanner scanner = new Scanner (System.in);

        System.out.println("Welcome to Sorting Algorithm Comparator\n");
        while(true){
            //Initializers per loop
            ArrayList<Integer> unsortedSet = new ArrayList<>();
            int sizechoice = 0;

            //size set segment
            System.out.println("\nSet Size Options\n 1 - user input \n 2- randomized");
            while (true) {
                try {
                    System.out.print("\nSelect set size setting: ");
                    sizechoice = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Input type invalid!");
                    scanner.nextLine();
                }
            }

            //set size option output
            if (sizechoice == 1){
                int setSize = 0;

                //input size loop
                while(true) {
                    while (true) {
                        try {
                            System.out.print("\nInput set size (5 - 100,000): ");
                            setSize = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Input type invalid!");
                            scanner.nextLine();
                        }
                    }

                    if (setSize < 5 || setSize > 100000){
                        System.out.println("Input out of bounds!");
                    } else {
                        break;
                    }
                }
                //input size set
                unsortedSet = func.inputSet(setSize);
                func.SortingAlgos(unsortedSet);
            } else if (sizechoice == 2){
                //randomized set
                unsortedSet = func.randomSet();
                func.SortingAlgos(unsortedSet);
            } else {
                System.out.println("Unidentified Input");
                break;
            }

            //program loop check
            while (true) {
                String loopinput = null;
                String loopChoice = null;

                System.out.print("\nRun another Set? Y/N: ");

                try {
                    loopinput = scanner.next();
                    scanner.nextLine();
                }catch (InputMismatchException e){
                    System.out.println("Input type invalid!");
                }

                loopChoice = loopinput.toUpperCase();
                if (loopChoice.equals("Y")){
                    break;
                } else if (loopChoice.equals("N")) {
                    scanner.close();
                    return;
                } else {
                    System.out.println("unidentified response");
                }
            }
        }
    }
}
