package zero.to.mastery.data_structures.arrays;

/**
 * Demonstrates missing number concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class MissingNumber {
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
        int intArray[] = {1,2,3,4,5,6,7,9,10,11,13,14};
        MissingNumber m = new MissingNumber();
        m.missingNumber(intArray);
    }

    /**
     * Executes missing number logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param intArray input value used by the missing number process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void missingNumber(int[] intArray) {
        int missingNumber = 0;
        for (int i = 1; i < intArray.length; i++) {
            System.out.println(i + " not " + intArray[i-1]);
            if(i != intArray[i-1]) {
                missingNumber = i;
                break;
            }
        }
        System.out.println("Missing Number is " + missingNumber);
    }
}
