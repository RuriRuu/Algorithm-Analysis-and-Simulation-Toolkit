import Part_1.Part1_Main_Module;
import Part_3.Part3_Main_Module;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_Program {
    public static void main(String[] args) {
        Part1_Main_Module P1 = new Part1_Main_Module();
        Part3_Main_Module P3 = new Part3_Main_Module();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int choice = 0;
            System.out.println("\n===== Algorithm-Analysis-and-Simulation-Toolkit =====");
            System.out.println("1 | Sorting Algorithm Comparator");
            System.out.println("2 | Kruskal's and Prim's Algorithm Simulator");
            System.out.println("3 | Recursive Functions Simulator");
            System.out.println("4 | Exit Program \n");

            try{
                System.out.print("Input Choice: ");
                choice = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Input type invalid!");
                scanner.nextLine();
            }

            switch (choice){
                case 1:
                    P1.Menu();
                    break;
                case 2:
                    //insert P2.Menu(); here
                    break;
                case 3:
                    P3.Menu();
                    break;
                case 4:
                    System.out.println("Exiting Simulation Toolkit...");
                    return;
                default:
                    System.out.println("Unidentified response");
            }
        }
    }
}

