package zero.to.mastery.algorithms.recursions;

/**
 * Demonstrates decimal to binary concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class DecimalToBinary {
    // rumus decimal to binary
    // n mod 2 + 10 * f(n/2)
    /**
     * Executes decimal to binary logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param n input value used by the decimal to binary process
     * @return computed int result produced by the decimal to binary process
     */
    private static int decimalToBinary(int n) {
        if (n == 0) {
            return 0;
        }
        return n%2 + 10*decimalToBinary(n/2);
    }

    /**
     * Executes main logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        System.out.println(decimalToBinary(10));
    }
}
