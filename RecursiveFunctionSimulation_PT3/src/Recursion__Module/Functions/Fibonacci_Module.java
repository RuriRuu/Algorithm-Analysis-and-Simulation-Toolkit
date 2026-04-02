package Recursion__Module.Functions;

public class Fibonacci_Module {
    public static int fibonacci(int n) {
        System.out.println("fibonacci(" + n + ")");
        if (n == 0) {
            System.out.println(" -> 0 (base case)");
            return 0;
        } else if (n == 1) {
            System.out.println(" -> 1 (base case)");
            return 1;
        } else {
            System.out.println(" -> fibonacci(" + (n - 1) + ") + fibonacci(" + (n - 2) + ")");
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            System.out.println("Return fibonacci(" + n + ") = " + result);
            return result;
        }
    }
}
