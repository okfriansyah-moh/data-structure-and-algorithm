package zero.to.mastery.algorithms.recursions;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates fibonacci concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class Fibonacci {
    /*
    Fibonacci itu penjumlahan dari index sebelumnya
    Misal 0,1,1,2,3,5,8,13,21,34,55,144 ....
    patternnya each value is the sum of 2 previous values
    dan kalau n nya kurang dari 2 selalu return n
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
        System.out.println("Fibonacci Recursive dari 10 = " + fibonacciRecursive(10));
        System.out.println("Fibonacci Iterative dari 10 = " + fibonacctiIterative(10));

    }

    // Recursive fibonacci big O(2^n), karena dipanggil 2 kali recursionnya.
    /**
     * Executes fibonacci recursive logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param n input value used by the fibonacci recursive process
     * @return computed int result produced by the fibonacci recursive process
     */
    private static int fibonacciRecursive(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    /**
     * Executes fibonaccti iterative logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param n input value used by the fibonaccti iterative process
     * @return computed int result produced by the fibonaccti iterative process
     */
    private static int fibonacctiIterative(int n) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        for (int i = 2; i < (n+1); i++) {
            arr.add(arr.get(i-2) + arr.get(i-1));
        }
        return arr.get(n);
    }
}
