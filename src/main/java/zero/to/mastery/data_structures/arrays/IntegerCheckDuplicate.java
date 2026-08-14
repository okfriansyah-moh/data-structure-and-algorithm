package zero.to.mastery.data_structures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates integer check duplicate concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class IntegerCheckDuplicate {

    // O(n^2) approach
    List<Integer> data = new ArrayList<>();
    /**
     * Executes is unique2 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param intArray input value used by the is unique2 process
     * @return computed boolean result produced by the is unique2 process
     */
    public boolean isUnique2(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i+1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(n) approach
    /**
     * Executes is unique logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param intArray input value used by the is unique process
     * @return computed boolean result produced by the is unique process
     */
    public boolean isUnique(int[] intArray) {
        // TODO
        int temp = 0;
        for (int i : intArray) {
            if (i == temp) {
                return false;
            }
            temp = i;
        }
        return true;
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
        IntegerCheckDuplicate integerCheckDuplicate = new IntegerCheckDuplicate();
        int[] intArray = {1,2,3,4,5,6,6};
        System.out.println(integerCheckDuplicate.isUnique(intArray));
    }
}
