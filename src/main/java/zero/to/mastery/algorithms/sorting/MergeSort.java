package zero.to.mastery.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implements the Merge Sort algorithm - a divide-and-conquer sorting approach.
 * 
 * <p><b>Time Complexity:</b> O(n log n) in all cases (best, average, worst)
 * <p><b>Space Complexity:</b> O(n) - requires additional space for merging
 * <p><b>Stability:</b> Stable - maintains relative order of equal elements
 *
 * <p><b>How Merge Sort Works:</b></p>
 * <ol>
 *   <li><b>Divide:</b> Recursively split the array in half until single elements remain</li>
 *   <li><b>Conquer:</b> Merge the sorted subarrays back together in sorted order</li>
 * </ol>
 *
 * <p><b>Visual Example with [3, 7, 2, 1]:</b></p>
 * <pre>
 * SPLITTING PHASE:
 *        [3, 7, 2, 1]
 *       /            \
 *    [3, 7]         [2, 1]
 *    /    \         /    \
 *  [3]   [7]     [2]    [1]
 *
 * MERGING PHASE (back up to single array):
 *   [3,7]  +  [1,2]  →  [1,2,3,7]
 * </pre>
 *
 * <p><b>Advantages:</b></p>
 * <ul>
 *   <li>Guaranteed O(n log n) performance</li>
 *   <li>Stable sort (preserves order of equal elements)</li>
 *   <li>Excellent for external sorting (large datasets)</li>
 *   <li>Naturally parallelizable</li>
 * </ul>
 *
 * <p><b>Disadvantages:</b></p>
 * <ul>
 *   <li>Requires O(n) extra space (not in-place like QuickSort)</li>
 *   <li>Slightly slower than QuickSort on small arrays in practice</li>
 * </ul>
 */
public class MergeSort {

    /**
     * Public wrapper method that converts a primitive Integer array to a List,
     * performs merge sort, and converts the result back to an array.
     *
     * <p><b>Example:</b></p>
     * <pre>
     * Integer[] numbers = {5, 2, 8, 1, 9};
     * Integer[] sorted = MergeSort.mergeSort(numbers);
     * // Result: [1, 2, 5, 8, 9]
     * </pre>
     *
     * @param array the array to sort
     * @return a new sorted array (original array remains unchanged)
     */
    public static Integer[] mergeSort(Integer[] array) {
        return mergeSort(new ArrayList<>(Arrays.asList(array))).toArray(new Integer[0]);
    }

    /**
     * Recursively divides the array into smaller subarrays and merges them back in sorted order.
     * This is the core divide-and-conquer implementation of merge sort.
     *
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Base case: if array has only 1 element, it's already sorted - return it</li>
     *   <li>Divide: split array at midpoint into left and right halves</li>
     *   <li>Conquer: recursively sort both halves</li>
     *   <li>Combine: merge the two sorted halves using {@link #merge(List, List)}</li>
     * </ol>
     *
     * <p><b>Step-by-step example with [38, 27, 43, 3]:</b></p>
     * <pre>
     * Input: [38, 27, 43, 3]
     * 
     * DIVIDE:
     * Split 1: Left=[38, 27], Right=[43, 3]
     * Split 2: Left=[38], Left2=[27], Right=[43], Right2=[3]
     * 
     * MERGE (combining sorted pieces):
     * Merge [38] + [27] → [27, 38]
     * Merge [43] + [3] → [3, 43]
     * Merge [27, 38] + [3, 43] → [3, 27, 38, 43]
     * </pre>
     *
     * @param array the unsorted list to sort
     * @return a new sorted list
     */
    public static List<Integer> mergeSort(List<Integer> array) {
        if (array.size() == 1) {
            return array;  // Base case: single element is already sorted
        }
        
        // DIVIDE: Split the array into two halves
        List<Integer> left = array.subList(0, array.size() / 2);
        System.out.println("Splitting left: " + left);
        List<Integer> right = array.subList(array.size() / 2, array.size());
        System.out.println("Splitting Right: " + right);
        
        // CONQUER: Recursively sort both halves, then COMBINE by merging
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * Merges two sorted lists into a single sorted list.
     * This is the key operation that makes merge sort efficient.
     * Time Complexity: O(n + m) where n and m are sizes of left and right lists.
     *
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Compare elements from both lists starting at the beginning</li>
     *   <li>Add the smaller element to the merged result</li>
     *   <li>Move to the next element in whichever list it came from</li>
     *   <li>When one list is exhausted, add all remaining elements from the other list</li>
     * </ol>
     *
     * <p><b>Step-by-step example merging [2, 5] and [1, 3, 4]:</b></p>
     * <pre>
     * Left: [2, 5]    Right: [1, 3, 4]
     * 
     * Step 1: Compare 2 vs 1 → 1 is smaller, add 1
     *         Merged: [1]  Left: [2, 5]  Right: [3, 4]
     * 
     * Step 2: Compare 2 vs 3 → 2 is smaller, add 2
     *         Merged: [1, 2]  Left: [5]  Right: [3, 4]
     * 
     * Step 3: Compare 5 vs 3 → 3 is smaller, add 3
     *         Merged: [1, 2, 3]  Left: [5]  Right: [4]
     * 
     * Step 4: Compare 5 vs 4 → 4 is smaller, add 4
     *         Merged: [1, 2, 3, 4]  Left: [5]  Right: []
     * 
     * Step 5: Right is empty, add remaining from left
     *         Merged: [1, 2, 3, 4, 5]
     * </pre>
     *
     * <p><b>Why use "<=" instead of "<"?</b></p>
     * <p>Using "<=" ensures stable sorting. Equal elements maintain their original relative order.
     * For example: merging [3a, 5] with [3b, 7] produces [3a, 3b, 5, 7], not [3b, 3a, 5, 7]</p>
     *
     * @param left the left sorted list
     * @param right the right sorted list
     * @return a new merged and sorted list
     */
    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        
        // Compare elements from both lists and add the smaller one
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {  // Use "<=" for stable sorting
                merged.add(left.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        
        // Add all remaining elements (one list will be empty, the other won't)
        // These are already sorted, just append them as-is
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));
        System.out.println("Merged: " + merged);
        return merged;
    }

    /**
     * Demonstrates merge sort with a sample array of mixed-order integers.
     * Shows the sorting process with detailed split and merge output.
     *
     * <p><b>Example Input:</b> [1, 8, 54, 9, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46]</p>
     * <p><b>Example Output:</b> [0, 0, 1, 1, 8, 9, 30, 45, 46, 50, 54, 65, 90, 100]</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Integer[] array = {1, 8, 54, 9, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46};
        // Sort and print each element on a new line
        Arrays.stream(mergeSort(array)).forEach(System.out::println);
    }
}
