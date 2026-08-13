package zero.to.mastery.algorithms.sorting;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Implements the QuickSort algorithm - an efficient divide-and-conquer sorting approach.
 * 
 * <p><b>Performance:</b></p>
 * <ul>
 *   <li>Average Case: O(n log n)</li>
 *   <li>Worst Case: O(n²) - when pivot is always smallest/largest (rare with good pivot selection)</li>
 *   <li>Space Complexity: O(log n) - only uses stack space for recursion</li>
 * </ul>
 *
 * <p><b>Stability:</b> NOT stable - may reorder equal elements</p>
 *
 * <p><b>How QuickSort Works:</b></p>
 * <ol>
 *   <li><b>Choose a Pivot:</b> Select an element (typically the last one)</li>
 *   <li><b>Partition:</b> Rearrange so elements smaller than pivot are on left, larger on right</li>
 *   <li><b>Recursively Sort:</b> Apply QuickSort to left and right partitions</li>
 * </ol>
 *
 * <p><b>Visual Example with [3, 7, 2, 1, 8]:</b></p>
 * <pre>
 * Original:     [3, 7, 2, 1, 8]
 * Pivot = 8
 * After partition: [3, 7, 2, 1, 8]  ← All smaller elements to left
 *                                 ^  ← Pivot in final position
 * 
 * Left partition: [3, 7, 2, 1]
 *   Pivot = 1
 *   After: [1, 3, 7, 2]
 *   
 * Continue recursively until all partitions are sorted
 * </pre>
 *
 * <p><b>Why It's Popular:</b></p>
 * <ul>
 *   <li>In-place sorting (only O(log n) extra space)</li>
 *   <li>Very efficient in practice</li>
 *   <li>Good cache locality (doesn't need separate arrays)</li>
 *   <li>Faster than MergeSort for most real-world datasets</li>
 * </ul>
 *
 * <p><b>Note:</b> This class shows two different implementations.</p>
 */
public class QuickSort {

    /**
     * Recursively sorts an Integer array using the QuickSort algorithm.
     * This is the main entry point that handles the entire sorting process.
     * Time Complexity: Average O(n log n), Worst O(n²).
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Choose the rightmost element as the pivot</li>
     *   <li>Partition the array: move all elements < pivot to the left</li>
     *   <li>Recursively sort the left partition (elements before pivot)</li>
     *   <li>Recursively sort the right partition (elements after pivot)</li>
     * </ol>
     *
     * <p><b>Detailed Example: quickSort([5, 2, 8, 1, 9], 0, 4)</b></p>
     * <pre>
     * Initial: [5, 2, 8, 1, 9], left=0, right=4, pivot=9
     * After partition: [5, 2, 8, 1, 9]  (9 is already in correct position)
     * 
     * Left partition: [5, 2, 8, 1]
     *   Pivot = 1
     *   After partition: [1, 2, 8, 5]
     *   Left: [1]  Right: [8, 5]
     *   
     * Right partition: [8, 9]
     *   Pivot = 9
     *   After partition: [8, 9]
     * 
     * Final result: [1, 2, 5, 8, 9]
     * </pre>
     *
     * @param array the Integer array to sort
     * @param left the starting index of the partition to sort
     * @param right the ending index of the partition to sort
     * @return the same array, now sorted in ascending order
     */
    public static Integer[] quickSort(Integer[] array, int left, int right){
        int pivot;
        int partitionIndex;

        if(left < right) {
            pivot = right;  // Use last element as pivot
            System.out.println("Part: " + Arrays.asList(array).subList(left, right + 1) + " by " + array[pivot]);
            partitionIndex = partition(array, pivot, left, right);
            System.out.println("Result: " +  Arrays.asList(array).subList(left, right + 1));

            // Recursively sort left and right partitions
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
        return array;
    }

    /**
     * Partitions an array segment around a pivot element.
     * This is the key operation that makes QuickSort work - it rearranges elements
     * so that all elements smaller than the pivot are to its left.
     * Time Complexity: O(n) where n is the size of the partition.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Get the pivot value from the specified position</li>
     *   <li>Initialize partitionIndex to the left boundary</li>
     *   <li>Loop through all elements before the pivot</li>
     *   <li>If element < pivot, swap it with element at partitionIndex and increment</li>
     *   <li>Finally, swap the pivot to its final sorted position</li>
     * </ol>
     *
     * <p><b>Step-by-step Example: partition([5, 2, 8, 1], pivot_index=3, left=0, right=3)</b></p>
     * <pre>
     * Array: [5, 2, 8, 1]
     * Pivot: 1 (at index 3)
     * partitionIndex starts at 0
     * 
     * i=0: 5 < 1? NO, skip
     * i=1: 2 < 1? NO, skip
     * i=2: 8 < 1? NO, skip
     * 
     * After loop: Swap pivot (1) to position 0
     * Result: [1, 2, 8, 5]
     * partitionIndex = 0
     * 
     * All elements at indices 0 to (partitionIndex-1) are now < pivot
     * Pivot is now in its final sorted position
     * </pre>
     *
     * <p><b>Another Example: partition([8, 3, 5, 4, 7], pivot_index=4, left=0, right=4)</b></p>
     * <pre>
     * Pivot: 7 (at index 4)
     * partitionIndex = 0
     * 
     * i=0: 8 < 7? NO
     * i=1: 3 < 7? YES → Swap arr[1] with arr[0] → [3, 8, 5, 4, 7], partitionIndex=1
     * i=2: 5 < 7? YES → Swap arr[2] with arr[1] → [3, 5, 8, 4, 7], partitionIndex=2
     * i=3: 4 < 7? YES → Swap arr[3] with arr[2] → [3, 5, 4, 8, 7], partitionIndex=3
     * 
     * After loop: Swap pivot (7) with arr[3] → [3, 5, 4, 7, 8]
     * Result: Left of 7 has [3, 5, 4], Right has [8]
     * </pre>
     *
     * @param array the array being partitioned
     * @param pivot the index of the pivot element
     * @param left the left boundary of the partition
     * @param right the right boundary of the partition
     * @return the index where the pivot ended up
     */
    public static int partition(Integer[] array, int pivot, int left, int right){
        int pivotValue = array[pivot];
        int partitionIndex = left;

        // Move all elements smaller than pivot to the left
        for(int i = left; i < right; i++) {
            if(array[i] < pivotValue){
                swap(array, i, partitionIndex);  // Swap with the next position for smaller element
                partitionIndex++;
            }
        }
        // Finally, place the pivot in its correct position
        swap(array, right, partitionIndex);
        return partitionIndex;
    }

    /**
     * Swaps two elements in an array by their indices.
     * This is a helper method used by partition() to rearrange elements.
     * Time Complexity: O(1).
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Save the first element in a temporary variable</li>
     *   <li>Copy the second element to the first position</li>
     *   <li>Copy the saved first element to the second position</li>
     * </ol>
     *
     * <p><b>Example: swap([10, 20, 30], 0, 2)</b></p>
     * <pre>
     * Before: [10, 20, 30]
     * Swap indices 0 and 2
     * After:  [30, 20, 10]
     * </pre>
     *
     * @param array the array containing elements to swap
     * @param index1 position of the first element
     * @param index2 position of the second element
     */
    private static void swap(Integer[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Recursive QuickSort implementation for primitive integer arrays.
     * This is an alternative implementation that works with int[] instead of Integer[].
     * Time Complexity: Average O(n log n), Worst O(n²).
     * Space Complexity: O(log n) for recursion stack.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Check if low < high (more than one element to sort)</li>
     *   <li>Partition the array around pivot (last element)</li>
     *   <li>Recursively sort left partition (low to pIndex-1)</li>
     *   <li>Recursively sort right partition (pIndex+1 to high)</li>
     * </ol>
     *
     * <p><b>Example: quickSort([3, 7, 2, 1, 8], 0, 4)</b></p>
     * <pre>
     * low=0, high=4
     * Partition around 8 → pIndex = 4
     * Recursively sort [3, 7, 2, 1]
     * Recursively sort [] (empty)
     * Final: [1, 2, 3, 7, 8]
     * </pre>
     *
     * @param arr the primitive integer array to sort
     * @param low the left boundary index
     * @param high the right boundary index (last element is pivot)
     */
    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition and get the pivot's final position
            int pIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pIndex - 1);     // Sort left side
            quickSort(arr, pIndex + 1, high);    // Sort right side
        }
    }

    /**
     * Partitions a primitive integer array using the last element as pivot.
     * This is an alternative implementation using Lomuto partition scheme.
     * Time Complexity: O(n).
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Get the pivot value (last element)</li>
     *   <li>Initialize i to low-1</li>
     *   <li>Loop through from low to high-1</li>
     *   <li>If arr[j] <= pivot, increment i and swap arr[i] with arr[j]</li>
     *   <li>Finally, place pivot at position i+1</li>
     * </ol>
     *
     * <p><b>Detailed Example: partition([9, 44, 6, 2, 1], low=0, high=4)</b></p>
     * <pre>
     * Pivot = 1 (last element)
     * i starts at -1
     * 
     * j=0: arr[0]=9, 9<=1? NO
     * j=1: arr[1]=44, 44<=1? NO
     * j=2: arr[2]=6, 6<=1? NO
     * j=3: arr[3]=2, 2<=1? NO
     * 
     * After loop: i=-1, Swap arr[0] with arr[-1] won't happen
     * Place pivot: Swap arr[0] with arr[4]
     * Result: [1, 44, 6, 2, 9]
     * Return: 0
     * </pre>
     *
     * <p><b>Another Example: partition([5, 2, 8, 1, 3], low=0, high=4)</b></p>
     * <pre>
     * Pivot = 3
     * i = -1
     * 
     * j=0: 5<=3? NO
     * j=1: 2<=3? YES → i becomes 0, swap arr[0] with arr[1] → [2, 5, 8, 1, 3]
     * j=2: 8<=3? NO
     * j=3: 1<=3? YES → i becomes 1, swap arr[1] with arr[3] → [2, 1, 8, 5, 3]
     * 
     * After loop: Place pivot → Swap arr[2] with arr[4] → [2, 1, 3, 5, 8]
     * Return: 2
     * All elements left of 3 are <= 3, all to right are > 3
     * </pre>
     *
     * @param arr the array being partitioned
     * @param low the left boundary of partition
     * @param high the right boundary (pivot location)
     * @return the final position of the pivot
     */
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Last element is pivot
        int i = (low - 1);  // Track the position to place smaller elements

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;  // Expand the "smaller elements" region
                
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        // Note: The line below creates an unused HashMap and can be removed
        HashMap<Integer,Integer> mapData = new HashMap<>();
        
        return i + 1;
    }


    /**
     * Prints all elements of an integer array in a single line.
     * Useful for displaying the current state of the array during sorting.
     * Time Complexity: O(n).
     *
     * <p><b>Example:</b></p>
     * <pre>
     * printArray(new int[]{3, 1, 4, 1, 5});
     * Output: 3 1 4 1 5
     * </pre>
     *
     * @param arr the primitive integer array to print
     */
    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    /**
     * Demonstrates both QuickSort implementations with sample arrays.
     * Shows how the algorithm works with Integer[] and int[] arrays.
     *
     * <p><b>First Approach (Integer[]):</b></p>
     * <pre>
     * Input: [1, 9, 54, 8, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46]
     * Output: [0, 0, 1, 1, 8, 9, 30, 45, 46, 50, 54, 65, 90, 100]
     * </pre>
     *
     * <p><b>Second Approach (int[]):</b></p>
     * <pre>
     * Input: [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0]
     * Output: 0 1 2 4 5 6 44 63 87 99 283
     * </pre>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // First implementation: Sort Integer array
        Integer[] array = {1, 9, 54, 8, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46};
        System.out.println(Arrays.asList(quickSort(array, 0 , array.length - 1)));

        // Second implementation: Sort primitive int array
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        QuickSort qs = new QuickSort();

        qs.quickSort(numbers, 0, numbers.length - 1);
        printArray(numbers);
    }
}
