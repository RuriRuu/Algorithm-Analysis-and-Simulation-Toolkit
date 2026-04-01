package Recursion__Module;

import java.util.Scanner;

import static Recursion__Module.Functions.Factorial_Module.factorial;
import static Recursion__Module.Functions.Fibonacci_Module.fibonacci;
import static Recursion__Module.Functions.TowerOfHanoi_Module.towerOfHanoi;

public class RecursionShowcase_Module {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("===== Recursion Showcase =====");

        while (true)
        {
            try{
                System.out.println("===== Factorial =====");
                System.out.print("Enter Value for Factorial: ");
                int factorialInput = scan.nextInt();
                int factResult = factorial(factorialInput);
                System.out.println("Result = " + factResult);
                System.out.println("====================");
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input, Please try again");
            }
        }

        while (true)
        {
            try{
                System.out.println("===== Fibonacci =====");
                System.out.print("Enter Value for Fibonacci: ");
                int fibInput = scan.nextInt();
                int fibResult = fibonacci(fibInput);
                System.out.println("Result = " + fibResult);
                System.out.println("====================");
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input, Please try again");
            }
        }
        while (true)
        {
            try{
                System.out.println("===== Tower of Hanoi =====");
                System.out.print("Enter Amount of Disks: ");
                int diskInput = scan.nextInt();
                towerOfHanoi(diskInput, 'A', 'C', 'B');
                System.out.println("====================");
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input, Please try again");
            }
        }
    }
}
