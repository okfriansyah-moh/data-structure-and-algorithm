package zero.to.mastery.data_structures.arrays;

/**
 * Demonstrates permutation concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class Permutation {
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
        Permutation permutation = new Permutation();
        int[] array1 = {1,2,3,4,5,6};
        int[] array2 = {6,5,4,3,2,1};
        System.out.println(permutation.permutation(array1,array2));
    }

    // Permutation
    /**
     * Executes permutation logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param array1 input value used by the permutation process
     * @param array2 input value used by the permutation process
     * @return computed boolean result produced by the permutation process
     */
    public boolean permutation(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        int sum1 = 0;
        int sum2 = 0;
        int mul1 = 1;
        int mul2 = 1;

        for (int i = 0; i < array1.length; i++) {
            sum1 += array1[i];
            sum2 += array2[i];
            mul1 *= array1[i];
            mul2 *= array2[i];
        }

        if (sum1 == sum2 && mul1 == mul2) {
            return true;
        }
        return false;
    }
}
