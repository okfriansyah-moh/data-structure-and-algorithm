package zero.to.mastery.dynamic_programming;

import java.util.HashMap;

/**
 * Demonstrates dynamic fibonacci concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class DynamicFibonacci {
    private static final HashMap<Integer, Integer> cache = new HashMap<>();
    /**
     * Executes fibonacci master logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param n input value used by the fibonacci master process
     * @return computed int result produced by the fibonacci master process
     */
    public static int fibonacciMaster(int n) {
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        if(n < 2){
            return n;
        }
        cache.put(n, fibonacciMaster(n - 1) + fibonacciMaster(n - 2));
        return cache.get(n);
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
        System.out.println(fibonacciMaster(1000));
    }

}
