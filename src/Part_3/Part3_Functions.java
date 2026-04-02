package Part_3;

import java.util.Scanner;

import static Part_3.Functions.Factorial_Module.factorial;
import static Part_3.Functions.Fibonacci_Module.fibonacci;
import static Part_3.Functions.TowerOfHanoi_Module.towerOfHanoi;

public class Part3_Functions {
    Scanner scanner = new Scanner(System.in);

    public void Factorial(){
        while (true)
        {
            System.out.println("\n===== Factorial =====");
            try{
                System.out.print("Enter Value for Factorial: ");

                int factorialInput = scanner.nextInt();
                int factResult = factorial(factorialInput);

                System.out.println("Result = " + factResult);
                System.out.println("====================");
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input, Please try again");
            }
        }
    }

    public void Fibonacci(){
        while (true)
        {
            System.out.println("\n===== Fibonacci =====");
            try{
                System.out.print("Enter Value for Fibonacci: ");

                int fibInput = scanner.nextInt();
                int fibResult = fibonacci(fibInput);

                System.out.println("Result = " + fibResult);
                System.out.println("====================");
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input, Please try again");
            }
        }
    }

    public void Hanoi(){
        while (true)
        {
            System.out.println("\n===== Tower of Hanoi =====");
            try{

                System.out.print("Enter Amount of Disks: ");
                int diskInput = scanner.nextInt();
                towerOfHanoi(diskInput, 'A', 'C', 'B');
                System.out.println("====================");
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input, Please try again");
            }
        }
    }


}
