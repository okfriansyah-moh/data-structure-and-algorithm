package zero.to.mastery.algorithms.recursions;

/**
 * Demonstrates how to convert a positive decimal number into its binary
 * representation using recursion.
 *
 * <p>
 * This implementation follows the standard mathematical approach:
 * </p>
 * 
 * <pre>
 * decimalToBinary(n) = n % 2 + 10 * decimalToBinary(n / 2)
 * </pre>
 *
 * <p>
 * The method repeatedly divides the value by two and keeps the remainder from
 * each step. For example:
 * </p>
 * 
 * <pre>
 * decimalToBinary(10) = 1010
 * 10 % 2 = 0, then 5 % 2 = 1, then 2 % 2 = 0, then 1 % 2 = 1
 * The remainders are assembled in reverse order to form the binary value 1010.
 * </pre>
 *
 * <p>
 * Recursion is used here to make the conversion easy to follow conceptually,
 * but it is not the most
 * efficient approach for very large inputs because each recursive call adds a
 * stack frame.
 * </p>
 */
public class DecimalToBinary {
    // Decimal-to-binary formula:
    // n mod 2 + 10 * f(n / 2)
    // This keeps the least significant bit first, then recursively builds the
    // remaining bits.

    /**
     * Converts a decimal number to its binary representation using recursion.
     *
     * <p>
     * The method stops when the value reaches zero, which acts as the base case.
     * Every recursive step
     * asks Java to compute the remainder of the current number divided by two and
     * then prepend that value to
     * the binary result of the smaller quotient.
     * </p>
     *
     * <p>
     * Example usage:
     * </p>
     * 
     * <pre>
     * int result = decimalToBinary(10); // result == 1010
     * </pre>
     *
     * @param n the non-negative decimal number to convert; values below zero are
     *          not handled by this example
     * @return the binary representation of {@code n} assembled as an integer using
     *         recursive decomposition
     */
    private static int decimalToBinary(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 2 + 10 * decimalToBinary(n / 2);
    }

    /**
     * Demonstrates the recursive conversion in a small console example.
     *
     * <p>
     * This method is used only for learning and debugging. It prints the binary
     * result to the console so
     * developers can visually confirm that the recursion is producing the expected
     * output.
     * </p>
     *
     * @param args command-line arguments; not used by this example
     */
    public static void main(String[] args) {
        System.out.println(decimalToBinary(10));
    }
}
