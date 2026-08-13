package zero.to.mastery.algorithms.recursions;

/**
 * Demonstrates sum of digits concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class SumOfDigits {
    // How to find the sum of digits of a positive integer number using recursion?
    // Ex : 10 = for the sum is 1 + 0 = 1
    // Ex : 123 = for the sum is 1 + 2 + 3 = 6
    // Ex : 4 = 4
    /**
     * Executes sum of digits logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param n input value used by the sum of digits process
     * @return computed int result produced by the sum of digits process
     */
    private static int sumOfDigits(int n) {
        if (n < 0 || n == 0) {
            return 0;
        }
        return n%10 + sumOfDigits(n/10);
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
        System.out.println(sumOfDigits(4));
    }
}
