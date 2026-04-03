package Part_2;
import java.util.Scanner;
import static Part_2.Part2_Functions.*;

public class Part2_Main_Module {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("==== Select an action ====");
        System.out.println("1. Kruksal's Algorithm");
        System.out.println("2. Prim's Algorithm");

        int choice = 0;
        while(true){
        try {
            choice = scan.nextInt();
            break;
        } catch (Exception e) {
            System.out.println("Enter a valid choice: ");
        }
        }

        if (choice == 1){
            kruksals(scan);
        } else if (choice == 2) {
            prims(scan);
        }
    }
}
