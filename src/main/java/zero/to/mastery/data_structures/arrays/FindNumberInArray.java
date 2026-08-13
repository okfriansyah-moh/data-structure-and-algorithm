package zero.to.mastery.data_structures.arrays;

/**
 * Demonstrates find number in array concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class FindNumberInArray {
    /**
     * Executes search in array logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param intArray input value used by the search in array process
     * @param valueToSearch input value used by the search in array process
     * @return computed int result produced by the search in array process
     */
    public int searchInArray(int[] intArray, int valueToSearch) {
        // TODO
        int count = 0;
        for (int i : intArray) {
            if (valueToSearch == i) {
                return count;
            }
            count++;
        }
        throw new IllegalArgumentException("No data found");
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
        FindNumberInArray findNumberInArray = new FindNumberInArray();
        int[] intArray = {1,2,3,4,5,6};
        System.out.println(findNumberInArray.searchInArray(intArray, 6));
    }
}
