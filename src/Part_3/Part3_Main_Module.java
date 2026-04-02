package Part_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Part3_Main_Module {

    public void Menu() {
        Part3_Functions func = new Part3_Functions();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int choice = 0;
            System.out.println("===== Recursion Showcase =====");
            System.out.println("1 | Factorial Tree");
            System.out.println("2 | Fibonacci Sequence");
            System.out.println("3 | Tower of Hanoi ");
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
                    func.Factorial();
                    break;
                case 2:
                    func.Fibonacci();
                    break;
                case 3:
                    func.Hanoi();
                    break;
                case 4:
                    System.out.println("Exiting Recursion Showcase...");
                    return;
                default:
                    System.out.println("Unidentified response");
            }
        }
    }
}
