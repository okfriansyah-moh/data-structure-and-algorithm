package zero.to.mastery.algorithms.recursions;

/**
 * Demonstrates factorial concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class Factorial {

    /* factorial itu perkalian dari n nya
       misal 5! = 5 * 4 * 3 * 2 * 1
     */
    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        System.out.println("Factorial of 5 Recursive = " + findFactorialRecursive(5));
        System.out.println("Factorial of 5 Iterative = " + findFactorialIterative(5));

    }

    /**
     * Executes find factorial recursive logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param number input value used by the find factorial recursive process
     * @return computed int result produced by the find factorial recursive process
     */
    private static int findFactorialRecursive(int number) {
        if (number == 1) {
            return 1;
        }
        return number * findFactorialRecursive(number-1);
    }

    /**
     * Executes find factorial iterative logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param number input value used by the find factorial iterative process
     * @return computed int result produced by the find factorial iterative process
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
