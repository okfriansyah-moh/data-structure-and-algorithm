package zero.to.mastery.algorithms.recursions;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    /*
    Fibonacci itu penjumlahan dari index sebelumnya
    Misal 0,1,1,2,3,5,8,13,21,34,55,144 ....
    patternnya each value is the sum of 2 previous values
    dan kalau n nya kurang dari 2 selalu return n
     */
    public static void main(String[] args) {
        System.out.println("Fibonacci Recursive dari 10 = " + fibonacciRecursive(10));
        System.out.println("Fibonacci Iterative dari 10 = " + fibonacctiIterative(10));

    }

    // Recursive fibonacci big O(2^n), karena dipanggil 2 kali recursionnya.
    private static int fibonacciRecursive(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

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
