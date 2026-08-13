package zero.to.mastery.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the selection sort algorithm using both {@link List} and
 * array-based inputs.
 *
 * <p>
 * Selection sort repeatedly chooses the smallest remaining value from the
 * unsorted portion of the data and swaps
 * it into the next sorted position. It is easy to follow and performs O(n^2)
 * comparisons in the worst case, so it is
 * useful as a conceptual algorithm but not ideal for large collections.
 * </p>
 *
 * <p>
 * The implementation below intentionally keeps the logic explicit so developers
 * can see the exact comparison and
 * swap flow behind the algorithm.
 * </p>
 */
public class SelectionSort {
    /**
     * Runs a simple demo that prints the sorted results for both a list and an
     * array input.
     *
     * @param args command-line arguments; not used by this example
     */
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(44);
        numbers.add(6);
        numbers.add(2);
        numbers.add(1);
        numbers.add(5);
        numbers.add(63);
        numbers.add(87);
        numbers.add(283);
        numbers.add(4);
        numbers.add(0);
        System.out.println(selectionSort(numbers));
        Integer[] array = { 5, 1, 85, 4, 7, 9, 0, 3, 1 };
        Arrays.stream(selectionSort(array)).forEach(System.out::println);
    }

    /**
     * Sorts a list in ascending order using selection sort.
     *
     * <p>
     * For each index {@code i}, the method scans the remainder of the list to find
     * the minimum value and then swaps
     * that minimum into the current position. The sorted portion grows from left to
     * right until the list is complete.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * List&lt;Integer&gt; data = List.of(9, 4, 7, 1);
     * selectionSort(data); // returns [1, 4, 7, 9]
     * </pre>
     *
     * @param data the unsorted list to sort
     * @return the list after it has been rearranged in ascending order
     */
    private static List<Integer> selectionSort(List<Integer> data) {
        int arrayLength = data.size();
        int temporal;
        for (int i = 0; i < arrayLength; i++) {
            int min = i;
            temporal = data.get(i);
            for (int j = i + 1; j < arrayLength; j++) {
                if (data.get(j) < data.get(min)) {
                    // update minimum if the current item is lower than the current minimum
                    min = j;
                }
            }
            data.set(i, data.get(min));
            data.set(min, temporal);
        }
        return data;
    }

    /**
     * Sorts an array in ascending order using selection sort.
     *
     * <p>
     * This version does the same work as the list variant, but works directly
     * against an integer array. It keeps a
     * record of the current minimum value and its index, then swaps it into place
     * once the scan of the remaining data
     * has finished.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * Integer[] values = { 5, 1, 4, 2 };
     * selectionSort(values); // values becomes [1, 2, 4, 5]
     * </pre>
     *
     * @param array the unsorted integer array to sort in place
     * @return the sorted array, using the same instance that was passed in
     */
    public static Integer[] selectionSort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            int minValue = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (minValue > array[j]) {
                    minValue = array[j];
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = minValue;
            array[minIndex] = temp;
        }
        return array;
    }
}
