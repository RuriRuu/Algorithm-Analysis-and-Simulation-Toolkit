package Part_3.Functions;

public class Factorial_Module {
    public static int factorial(int n) {
        System.out.println("factorial(" + n + ")");
        if (n == 1) {
            System.out.println(" -> 1 (base case)");
            return 1;
        } else {
            System.out.println(" -> " + n + " * factorial(" + (n - 1) + ")");
            int result = n * factorial(n - 1);
            System.out.println("Return factorial(" + n + ") = " + result);
            return result;
        }
    }
}
