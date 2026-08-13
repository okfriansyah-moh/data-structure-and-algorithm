package zero.to.mastery.algorithms.sorting;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Demonstrates quick sort concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class QuickSort {

    /**
     * Executes quick sort logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param array input value used by the quick sort process
     * @param left input value used by the quick sort process
     * @param right input value used by the quick sort process
     * @return computed integer[] result produced by the quick sort process
     */
    public static Integer[] quickSort(Integer[] array, int left, int right){
        int pivot;
        int partitionIndex;

        if(left < right) {
            pivot = right;
            System.out.println("Part: " + Arrays.asList(array).subList(left, right + 1) + " by " + array[pivot]);
            partitionIndex = partition(array, pivot, left, right);
            System.out.println("Result: " +  Arrays.asList(array).subList(left, right + 1));

            //sort left and right
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
        return array;
    }

    /**
     * Executes partition logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param array input value used by the partition process
     * @param pivot input value used by the partition process
     * @param left input value used by the partition process
     * @param right input value used by the partition process
     * @return computed int result produced by the partition process
     */
    public static int partition(Integer[] array, int pivot, int left, int right){
        int pivotValue = array[pivot];
        int partitionIndex = left;

        for(int i = left; i < right; i++) {
            if(array[i] < pivotValue){
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array, right, partitionIndex);
        return partitionIndex;
    }

    /**
     * Executes swap logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param array input value used by the swap process
     * @param index1 input value used by the swap process
     * @param index2 input value used by the swap process
     * Output: updates internal state and/or prints computed results to the console.
     */
    private static void swap(Integer[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /*
    Quick sort methodde 2
     */
    /**
     * Executes in-place quick sort on a primitive integer array.
     *
     * <p>Explanation: partitions the current range around a pivot, then recursively sorts
     * the left and right partitions until each segment has fewer than two elements.</p>
     *
     * @param arr input array to be sorted
     * @param low starting index of the current partition
     * @param high ending index of the current partition
     * Output: the same input array is reordered into ascending order.
     */
    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);

            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    /**
     * Partitions a primitive integer array around the last element as pivot.
     *
     * <p>Explanation: values less than or equal to the pivot are moved to the left side,
     * then the pivot is placed in its final sorted location.</p>
     *
     * @param arr array being partitioned
     * @param low starting index of the partition range
     * @param high ending index of the partition range (pivot location)
     * @return pivot index after partitioning
     */
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        HashMap<Integer,Integer> mapData = new HashMap<>();
        return i + 1;
    }


    /* print array */
    /**
     * Prints all elements of an integer array in one line.
     *
     * <p>Explanation: iterates through the array and writes each value to standard output
     * for quick inspection of the sorting result.</p>
     *
     * @param arr array to display
     * Output: console text that represents the array order.
     */
    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
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
        Integer[] array = {1, 9, 54, 8, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46};
        System.out.println(Arrays.asList(quickSort(array, 0 , array.length - 1)));

        // methode 2
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        QuickSort qs = new QuickSort();

        qs.quickSort(numbers, 0, numbers.length - 1);
        printArray(numbers);
    }
}
