package zero.to.mastery.algorithms.recursions;

/**
 * Demonstrates how factorials work and compares a recursive implementation with
 * an iterative one.
 *
 * <p>
 * A factorial is the product of all positive integers from 1 to n. For example:
 * </p>
 * 
 * <pre>
 * 5! = 5 * 4 * 3 * 2 * 1 = 120
 * </pre>
 *
 * <p>
 * Both methods below produce the same result, but they solve the problem in
 * different ways. The recursive
 * version expresses the mathematical definition directly, while the iterative
 * version avoids function-call overhead
 * and is often easier to reason about when performance matters.
 * </p>
 */
public class Factorial {

    /**
     * Demonstrates both implementations side by side in a small console example.
     *
     * <p>
     * Example output:
     * </p>
     * 
     * <pre>
     * Factorial of 5 Recursive = 120
     * Factorial of 5 Iterative = 120
     * </pre>
     *
     * @param args command-line arguments; not used by this example
     */
    public static void main(String[] args) {
        System.out.println("Factorial of 5 Recursive = " + findFactorialRecursive(5));
        System.out.println("Factorial of 5 Iterative = " + findFactorialIterative(5));
    }

    /**
     * Computes the factorial of a number using recursion.
     *
     * <p>
     * The recursive definition is:
     * </p>
     * 
     * <pre>
     * factorial(n) = n * factorial(n - 1)
     * factorial(1) = 1
     * </pre>
     *
     * <p>
     * Each call shrinks the problem by one until it reaches the base case. This
     * makes the code concise and
     * mathematically aligned with the definition, but it uses additional stack
     * memory for every recursive level.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * findFactorialRecursive(5) -> 5 * findFactorialRecursive(4) -> ... -> 120
     * </pre>
     *
     * @param number the positive integer whose factorial should be computed
     * @return the factorial of {@code number}
     */
    private static int findFactorialRecursive(int number) {
        if (number == 1) {
            return 1;
        }
        return number * findFactorialRecursive(number - 1);
    }

    /**
     * Computes the factorial of a number using an iterative loop.
     *
     * <p>
     * This approach starts from an accumulator of 1 and multiplies it by each value
     * from the number down to 1.
     * It avoids recursion and therefore avoids stack growth, which is simpler and
     * often preferred in production code
     * when the input is not extremely large.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * findFactorialIterative(5) -> 1 * 5 * 4 * 3 * 2 * 1 = 120
     * </pre>
     *
     * @param number the positive integer whose factorial should be computed
     * @return the factorial of {@code number}
     */
    private static int findFactorialIterative(int number) {
        int answer = 1;
        while (number > 0) {
            answer *= number;
            number--;
        }
        return answer;
    }
}
