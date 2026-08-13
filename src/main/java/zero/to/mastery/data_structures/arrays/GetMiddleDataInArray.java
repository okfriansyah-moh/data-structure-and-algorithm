package zero.to.mastery.data_structures.arrays;

import java.util.Arrays;

/**
 * Demonstrates get middle data in array concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class GetMiddleDataInArray {
    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(middle(intArray)));
    }

    /**
     * Extracts the middle segment of an array by removing the first and last elements.
     *
     * <p>Explanation: delegates to {@link Arrays#copyOfRange(int[], int, int)} with
     * start index {@code 1} and end index {@code arr.length - 1}.</p>
     *
     * @param arr source array
     * @return new array containing only the middle values
     */
    static int[] middle(int[] arr) {
        return Arrays.copyOfRange(arr, 1, arr.length-1);
    }
}
