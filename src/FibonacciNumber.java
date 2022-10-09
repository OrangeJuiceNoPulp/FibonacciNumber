import java.util.ArrayList;

public class FibonacciNumber {

    public static ArrayList<Long> fibonacciMemory = new ArrayList<Long>();
    // Array index n is the (n+2)th fibonacci number
    // Ex: index 0 is the 2nd fibonacci number

    public static long fibonacciNumber(int i) throws Exception {

        if (i < 0) {
            throw new Exception(
                    "Input must be a non-negative integer value. \"" + i + "\" is not a non-negative integer.");
        }

        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }

        // if (fibonacciMemory.size() - 1 >= i - 2) => if (fibonacciMemory.size() >= i - 1)
        // Checks to see if the nth fibonacci number is in the memory

        if (fibonacciMemory.size() >= i - 1) {
            return fibonacciMemory.get(i - 2);
        }

        long value = fibonacciNumber(i - 1) + fibonacciNumber(i - 2);

        fibonacciMemory.add(value);

        return value;
    }

    public static void main(String[] args) throws Exception {
        int fibonacciIndex;
        long fibonacciValue;

        try {
            fibonacciIndex = Integer.parseInt(args[0]);
            fibonacciValue = fibonacciNumber(fibonacciIndex);

            System.out.println(fibonacciValue);

        } catch (NumberFormatException e) {
            System.err.println(
                    "\nInput must be a non-negative integer value. \"" + args[0] + "\" is not a non-negative integer.");
            e.printStackTrace();
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(
                    "\nNo input given! Input must be a non-negative integer value for the nth fibonacci number you would like to compute.");
            e.printStackTrace();
            System.exit(1);
        }

    }
}
