import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class Assign1 {
    public static void main(String[] args) {
        // case of no arguments
        if (args.length == 0) {
            printHelp();
            return;
        }

        int i = 0;

        // loop through the arguments
        while (i < args.length) {
            String option = args[i];
            if (i + 1 >= args.length) {
                System.out.println("Missing argument for " + option);
                printHelp();
                System.exit(-1);
            }
            // fibonaci option
            else if (option.equals("-fib")) {
                // check if the next argument is an integer
                try {
                    int n = Integer.parseInt(args[++i]);
                    // check number range
                    if (n < 0 || n > 40) {
                        System.out.println("Fibonacci valid range is [0, 40]");
                    } else {
                        System.out.println("Fibonacci of " + n + " is " + fib(n));
                    }
                }
                // catch non integer inputs
                catch (NumberFormatException e) {
                    System.out.println("Fibonacci valid range is [0, 40]");
                }

            }
            // factorial option
            else if (option.equals("-fac")) {
                // check if the next argument is an integer
                try {
                    int n = Integer.parseInt(args[++i]);
                    // check number range
                    if (n < 0) {
                        System.out.println("Factorial valid range is [0, 2147483647]");
                    } else {
                        System.out.println("Factorial of " + n + " is " + factorial(n));
                    }
                }
                // catch non integer inputs
                catch (NumberFormatException e) {
                    System.out.println("Factorial valid range is [0, 2147483647]");
                }

            }
            // e option
            else if (option.equals("-e")) {
                // check if the next argument is an integer
                try {
                    int n = Integer.parseInt(args[++i]);
                    if (n < 1) {
                        System.out.println("Valid e iterations range is [1, 2147483647]");
                    } else {
                        System.out.println("Value of e using " + n + " iterations is " + taylor(n));
                    }
                }
                // catch non integer inputs
                catch (NumberFormatException e) {
                    System.out.println("Valid e iterations range is [1, 2147483647]");
                }

            }
            // unknown option
            else{
                System.out.println("Unknown command line argument: " + option);
                printHelp();
                System.exit(-1);
            }

            i++;
        }
    }

    // helper fib method
    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // helper factorial method
    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    // helper e method
    private static BigDecimal taylor(int n) {
        BigDecimal sum = BigDecimal.ZERO;
        MathContext mc = new MathContext(50);
        for (int i = 0; i < n; i++) {
            sum = sum.add(BigDecimal.ONE.divide(new BigDecimal(factorial(i)), mc));
        }
        return sum.setScale(16, RoundingMode.HALF_UP);

    }

    // print help method
    private static void printHelp(){
        System.out.println("--- Assign 1 Help ---");
        System.out.println("  -fib [n] : Compute the Fibonacci of [n]; valid range [0, 40]");
        System.out.println("  -fac [n] : Compute the factorial of [n]; valid range, [0, 2147483647]");
        System.out.println("  -e [n] : Compute the value of 'e' using [n] iterations; valid range [1, 2147483647]");
    }
}