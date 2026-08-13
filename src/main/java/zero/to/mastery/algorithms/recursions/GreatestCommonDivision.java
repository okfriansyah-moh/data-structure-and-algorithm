package zero.to.mastery.algorithms.recursions;

/**
 * Demonstrates the greatest common divisor (GCD) problem using recursion.
 *
 * <p>
 * GCD is the largest positive integer that divides two numbers without leaving
 * a remainder. For example:
 * </p>
 * 
 * <pre>
 * GCD(54, 24) = 6
 * because 54 has factors 1, 2, 3, 6, 9, 18, 27, 54
 * and 24 has factors 1, 2, 3, 4, 6, 8, 12, 24
 * the largest shared value is 6.
 * </pre>
 *
 * <p>
 * This implementation uses Euclid's algorithm, which repeatedly replaces the
 * larger number with the remainder
 * after division. The algorithm is efficient because it reduces the problem
 * size on each recursion step and quickly
 * reaches zero, where the answer is known.
 * </p>
 */
public class GreatestCommonDivision {
    // what is GCD?
    // GCD itu = greatest common divisor (factor)
    // Contoh : GCD or GCD 54 dan 24 itu berapa?
    // 54 itu bisa dicapai dengan 1 * 54 , 2 * 27, 3 * 18 , 6 * 9
    // Nah 24 itu bisa dicapai dengan 1 * 24, 2 * 12, 3 * 8, 4 * 6,
    // Complete divisor 54 itu 1,2,3,6,9, 18,27,54.
    // Complete divisor 24 itu 1,2,3,4,6,8,12,24.
    // GCD nya 1,2,3,6. Dan yang paling besar itu adalah 6.
    // Maka GCD(54,24) = 6
    /**
     * Executes gcd logic.
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * gcd(54, 24) = 6
     * gcd(8, 4) = 4
     * </pre>
     *
     * @param a the first number to compare
     * @param b the second number to compare
     * @return the greatest common divisor of {@code a} and {@code b}, or -1 when
     *         one of the inputs is negative
     */
    private static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Runs a simple demonstration of the algorithm using a pair of integers that
     * share a known divisor.
     *
     * @param args command-line arguments; not used in this example
     */
    public static void main(String[] args) {
        System.out.println(gcd(8, 4));
    }
}
