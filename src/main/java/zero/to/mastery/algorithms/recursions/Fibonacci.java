package zero.to.mastery.algorithms.recursions;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates two different approaches to calculating Fibonacci numbers.
 * The Fibonacci sequence is a series where each number is the sum of the two preceding ones.
 *
 * <p><b>Sequence Example:</b> 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 144...</p>
 *
 * <p><b>Comparison:</b></p>
 * <ul>
 *   <li><b>Recursive:</b> Time O(2^n), Space O(n) - elegant but inefficient for large n</li>
 *   <li><b>Iterative:</b> Time O(n), Space O(n) - much more efficient</li>
 * </ul>
 *
 * <p>This class demonstrates the trade-off between code readability (recursive) 
 * and performance (iterative).</p>
 *
 * <p><b>Use case:</b> For n=10, recursive makes 177 function calls, 
 * while iterative completes in just 10 iterations.</p>
 */
public class Fibonacci {
    /**
     * Runs both Fibonacci implementations to demonstrate their behavior.
     * This method calculates the 10th Fibonacci number using two different approaches.
     *
     * <p><b>Output:</b></p>
     * <pre>
     * Fibonacci Recursive dari 10 = 55
     * Fibonacci Iterative dari 10 = 55
     * </pre>
     *
     * <p>Both methods produce the same result, but iterative is much faster!</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Fibonacci Recursive dari 10 = " + fibonacciRecursive(10));
        System.out.println("Fibonacci Iterative dari 10 = " + fibonacctiIterative(10));
    }

    /**
     * Calculates the nth Fibonacci number using a recursive approach.
     * Time Complexity: O(2^n) - exponential, very inefficient for large n due to repeated calculations.
     * Space Complexity: O(n) - call stack depth.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Base case: if n < 2, return n (0 for n=0, 1 for n=1)</li>
     *   <li>Recursive case: return fib(n-1) + fib(n-2)</li>
     * </ol>
     *
     * <p><b>Example: fibonacciRecursive(5)</b></p>
     * <pre>
     *                    fib(5)
     *                   /      \
     *              fib(4)        fib(3)
     *             /      \       /      \
     *        fib(3)    fib(2)  fib(2)  fib(1)
     *        /   \      /  \    /  \
     *   fib(2) fib(1) fib(1) 0 fib(1) 0
     *   /  \
     * fib(1) 0
     * 
     * Result: 5
     * Note: fib(3) is calculated twice, fib(2) is calculated three times!
     * This redundant work grows exponentially with n.
     * </pre>
     *
     * <p><b>Performance Problem:</b></p>
     * For n=10: 177 function calls are made
     * For n=20: 21,891 function calls are made
     * For n=30: 2,178,309 function calls are made
     *
     * @param n the position in the Fibonacci sequence (0-based)
     * @return the nth Fibonacci number
     */
    private static int fibonacciRecursive(int n) {
        if (n < 2) {
            return n;  // Base case: fib(0)=0, fib(1)=1
        }
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);  // Recursive case
    }

    /**
     * Calculates the nth Fibonacci number using an iterative approach.
     * Time Complexity: O(n) - much more efficient than recursive
     * Space Complexity: O(n) - uses a list to store all values up to n
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Create a list and add base cases: [0, 1]</li>
     *   <li>Loop from index 2 to n, calculating each Fibonacci number as the sum of the two previous</li>
     *   <li>Return the value at index n</li>
     * </ol>
     *
     * <p><b>Example: fibonacctiIterative(7)</b></p>
     * <pre>
     * Iteration 1: arr = [0, 1, 1]         (0 + 1 = 1)
     * Iteration 2: arr = [0, 1, 1, 2]      (1 + 1 = 2)
     * Iteration 3: arr = [0, 1, 1, 2, 3]   (1 + 2 = 3)
     * Iteration 4: arr = [0, 1, 1, 2, 3, 5]    (2 + 3 = 5)
     * Iteration 5: arr = [0, 1, 1, 2, 3, 5, 8]  (3 + 5 = 8)
     * Iteration 6: arr = [0, 1, 1, 2, 3, 5, 8, 13] (5 + 8 = 13)
     * Return: 13
     * </pre>
     *
     * <p><b>Why it's better:</b></p>
     * For n=10: Only 10 iterations needed (vs 177 function calls in recursive)
     * For n=20: Only 20 iterations needed (vs 21,891 function calls in recursive)
     * No function call overhead, no redundant calculations!
     *
     * @param n the position in the Fibonacci sequence (0-based)
     * @return the nth Fibonacci number
     */
    private static int fibonacctiIterative(int n) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);  // Base case: fib(0) = 0
        arr.add(1);  // Base case: fib(1) = 1
        
        // Build up the sequence from 2 to n
        for (int i = 2; i < (n+1); i++) {
            arr.add(arr.get(i-2) + arr.get(i-1));  // Each number is sum of previous two
        }
        return arr.get(n);
    }
}
