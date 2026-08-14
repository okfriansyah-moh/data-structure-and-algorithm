package zero.to.mastery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates binary search target in array concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class BinarySearchTargetInArray {
    /**
     * Executes search target logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param ListIntegerarray input value used by the search target process
     * @param target input value used by the search target process
     * @return computed boolean result produced by the search target process
     */
    public boolean searchTarget(List<Integer>array, int target) {
        List<Integer> sortedArray = array.stream().sorted().collect(Collectors.toList());
        int left = 0, right = sortedArray.size()-1;
        while (left <= right) {
            var mid = Math.floor((left+right)/2);
            var foundVal = sortedArray.get((int) mid);
            if (foundVal == target) {
                return true;
            } else if (foundVal < target) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        return false;
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
        BinarySearchTargetInArray binarySearchTargetInArray = new BinarySearchTargetInArray();
        List<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(5);
        ar.add(3);
        ar.add(6);
        ar.add(9);
        ar.add(2);
        System.out.println(binarySearchTargetInArray.searchTarget(ar, 4));
    }
}
