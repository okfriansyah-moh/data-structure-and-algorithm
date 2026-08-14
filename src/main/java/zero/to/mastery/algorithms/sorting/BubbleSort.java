package zero.to.mastery.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the bubble sort algorithm using both a {@link List} and an
 * array.
 *
 * <p>
 * Bubble sort repeatedly scans the collection and swaps adjacent values when
 * they are out of order. The largest
 * remaining unsorted value moves to the end of the collection after each pass,
 * which makes the algorithm easy to
 * understand but inefficient for large datasets because its time complexity is
 * O(n^2).
 * </p>
 *
 * <p>
 * This class is meant as a learning example for understanding sorting behavior
 * and comparison-based swaps.
 * </p>
 */
public class BubbleSort {
    /**
     * Runs a small in-console demonstration of the algorithm on both a list and an
     * array.
     *
     * <p>
     * Example output includes the sorted list and the sorted array values after the
     * swaps are applied.
     * </p>
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
        System.out.println(bubbleSort(numbers));
        Integer[] array = { 8, 1, 56, 4, 7, 1, 87, 0 };
        Arrays.stream(bubbleSort(array)).forEach(System.out::println);
    }

    // Using a List for the first variant of the algorithm.
    /**
     * Sorts a list of integers in ascending order using bubble sort.
     *
     * <p>
     * The outer loop controls how many passes are made, while the inner loop
     * compares adjacent elements and swaps
     * them when the left value is greater than the right value. This continues
     * until each pass pushes the next
     * largest value toward the end.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * List&lt;Integer&gt; data = List.of(5, 2, 9, 1);
     * bubbleSort(data); // returns [1, 2, 5, 9]
     * </pre>
     *
     * @param data the unsorted list to sort
     * @return the same list after it has been reordered in ascending order
     */
    private static List<Integer> bubbleSort(List<Integer> data) {
        int arrayLength = data.size();
        int temporal;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    // swap numbers
                    temporal = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temporal);
                }
            }
        }
        return data;
    }

    // Using a primitive-array variant to show the same logic with arrays.
    /**
     * Sorts an integer array in ascending order using bubble sort.
     *
     * <p>
     * This method performs the same adjacent-swap logic as the list-based version,
     * but operates directly on a
     * boxed {@link Integer[]} array. It mutates the original array in place and
     * returns the same reference after
     * sorting it.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * Integer[] values = { 8, 1, 4 };
     * bubbleSort(values); // values becomes [1, 4, 8]
     * </pre>
     *
     * @param array the unsorted array to sort in place
     * @return the sorted array, same instance as the original input
     */
    public static Integer[] bubbleSort(Integer[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
