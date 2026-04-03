package Recursion__Module.Functions;

public class Fibonacci_Module {
    public static int fibonacci(int n) {

        int n1 = 0, n2 = 1;

        for(int i = 0; i < n; i++){
            //prints fib in a more clear way
            System.out.println(n1 + " ");

            int n3 = n2 + n1;
            n1 = n2;
            n2 = n3;
        }
        return n;
    }
}

