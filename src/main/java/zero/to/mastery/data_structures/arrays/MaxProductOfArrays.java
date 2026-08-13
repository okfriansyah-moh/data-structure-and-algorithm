package zero.to.mastery.data_structures.arrays;

/**
 * Demonstrates max product of arrays concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class MaxProductOfArrays {
    // Max Product
    /**
     * Executes max product logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param intArray input value used by the max product process
     * @return computed string result produced by the max product process
     */
    public String maxProduct(int[] intArray) {
        int maxProduct = 0;
        String pairs = "";
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i+1; j < intArray.length; j++) {
                if (intArray[i] * intArray[j] > maxProduct) {
                    maxProduct = intArray[i] * intArray[j];
                    pairs = Integer.toString(intArray[i]) + "," + Integer.toString(intArray[j]);
                }
            }
        }
        return pairs;
    }

    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        MaxProductOfArrays maxProductOfArrays = new MaxProductOfArrays();
        int[] intArray = {10,20,30,40,50};
        String pairs = maxProductOfArrays.maxProduct(intArray);
        System.out.println(pairs);
    }
}
