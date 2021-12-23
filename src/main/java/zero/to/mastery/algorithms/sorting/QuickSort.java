package zero.to.mastery.algorithms.sorting;

import java.util.Arrays;
import java.util.HashMap;

public class QuickSort {

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

    private static void swap(Integer[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /*
    Quick sort methodde 2
     */
    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);

            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

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
    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

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
