package zero.to.mastery.algorithms.recursions;

/**
 * Demonstrates powers of numbers concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class PowersOfNumbers {
    // How to calculate power of a number using recursion?
    // Ex : x^n = x * x * x * x (n times)
    // 2^4 = 2 * 2 * 2 * 2
    // x^a*b = x^a+b
    // x^3 * x^4 = x^7
    // the stop condition is jika 2^0 = 1 dan 2^1 = 2
    // the stop condition is kalo n = 0 itu pasti 1 dan n = 1 itu sama dengan n itu sendiri
    /**
     * Executes power logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param base input value used by the power process
     * @param exp input value used by the power process
     * @return computed int result produced by the power process
     */
    private static int power(int base, int exp) {
        if (exp < 0) {
            return -1;
        }
        if (exp == 0) {
            return 1;
        }
        return base * power(base, exp-1);
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
        System.out.println(power(10,9));
    }
}
