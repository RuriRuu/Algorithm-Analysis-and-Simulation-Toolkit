package Part_3.Functions;

import java.math.BigInteger;

public class Factorial_Module {
    //BigInt processing instead of int
    //in the case the value input would generate a result exceeding bot int and long limits
    public static BigInteger factorial(int n) {
        if (n == 1) {
            System.out.println(" -> 1 (base case)");
            return BigInteger.ONE;
        } else {
            System.out.println(" -> " + n + " * factorial(" + (n - 1) + ")");
            BigInteger result = BigInteger.valueOf(n).multiply(factorial(n - 1));
            return result;
        }
    }
}