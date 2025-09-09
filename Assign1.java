import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

// TODO: make something like -fib a output the error message but keep going if there is an issue

public class Assign1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            printHelp();
            return;
        }

        int i = 0;

        while (i < args.length) {
            String option = args[i];

            if (option.equals("-fib")) {
                if (i + 1 >= args.length || !isInteger(args[i + 1])) {
                    System.out.println("Fibonacci valid range is [0, 40]");
                } else {
                    int n = Integer.parseInt(args[++i]);
                    if (n < 0 || n > 40) {
                        System.out.println("Fibonacci valid range is [0, 40]");
                    } else {
                        System.out.println("Fibonacci of " + n + " is " + fib(n));
                    }
                }

            } else if (option.equals("-fac")) {
                if (i + 1 >= args.length || !isInteger(args[i + 1])) {
                    System.out.println("Factorial valid range is [0, 2147483647]");
                } else {
                    int n = Integer.parseInt(args[++i]);
                    if (n < 0) {
                        System.out.println("Factorial valid range is [0, 2147483647]");
                    } else {
                        System.out.println("Factorial of " + n + " is " + factorial(n));
                    }
                }

            } else if (option.equals("-e")) {
                if (i + 1 >= args.length || !isInteger(args[i + 1])) {
                    System.out.println("Valid e iterations range is [1, 2147483647]");
                } else {
                    int n = Integer.parseInt(args[++i]);
                    if (n < 1) {
                        System.out.println("Valid e iterations range is [1, 2147483647]");
                    } else {
                        System.out.println("Value of e using " + n + " iterations is " + taylor(n));
                    }
                }

            } else if (option.startsWith("-")) {
                System.out.println("Unknown command line argument: " + option);
                printHelp();
                System.exit(-1);
            }

            i++;
        }
    }

    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    private static BigDecimal taylor(int n) {
        BigDecimal sum = BigDecimal.ZERO;
        MathContext mc = new MathContext(50);
        for (int i = 0; i < n; i++) {
            sum = sum.add(BigDecimal.ONE.divide(new BigDecimal(factorial(i)), mc));
        }
        return sum.setScale(16, RoundingMode.HALF_UP);

    }

    private static void printHelp(){
        System.out.println("--- Assign 1 Help ---");
        System.out.println("  -fib [n] : Compute the Fibonacci of [n]; valid range [0, 40]");
        System.out.println("  -fac [n] : Compute the factorial of [n]; valid range, [0, 2147483647]");
        System.out.println("  -e [n] : Compute the value of 'e' using [n] iterations; valid range [1, 2147483647]");
    }

    private static boolean isInteger(String s) {
        if (s == null || s.isEmpty()) return false;
        int start = (s.charAt(0) == '-') ? 1 : 0;
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}