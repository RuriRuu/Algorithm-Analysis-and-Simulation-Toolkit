package Part_2;
import java.util.Scanner;
import static Part_2.Part2_Functions.*;

public class Part2_Main_Module {
    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("==== Select an action ====");
            System.out.println("1 | Kruksal's Algorithm");
            System.out.println("2 | Prim's Algorithm");
            System.out.println("4 | Return to main menu \n");

            int choice = 0;
            while (true) {
                try {
                    System.out.print("Input Choice: ");
                    choice = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Enter a valid choice: ");
                    scanner.nextLine();
                }
            }

            switch (choice){
                case 1:
                    krusksals(scanner);
                    break;
                case 2:
                    prims(scanner);
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Unidentified response");
            }
        }
    }
}
