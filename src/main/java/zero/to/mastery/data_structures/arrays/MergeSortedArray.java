package zero.to.mastery.data_structures.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    // Method 1
    public static int[] MargeTwoSortedArray1(int[] array1, int[] array2) {
        final int[] mergedArray = new int[array1.length + array2.length];
        int j = 0, k = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (j != array1.length && (k == array2.length || array1[j] < array2[k])) {
                mergedArray[i] = array1[j];
                j++;
            } else {
                mergedArray[i] = array2[k];
                k++;
            }
        }
        return mergedArray;
    }

    // Method 2
    private int[] mergeArrays(int[] arr1, int[] arr2) {
        // i is index count of arr1
        // j is index count of arr2
        // k is index count of mergedArray
        int i = 0, j = 0, k = 0;

        // mergedArrayLength will be total length of arr1 and arr2.
        int mergedArrayLength = arr1.length + arr2.length;

        // create mergedArray {an array which will have merged elements}
        int[] mergedArray = new int[mergedArrayLength];

        // checking elements of both array and adding the least element first in the merged array.
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k] = arr1[i];
                i++;
            } else {
                mergedArray[k] = arr2[j];
                j++;
            }
            k++;
        }
        /*
         some or one of the elements of one of the arrays will
         be remaining to be put into the merged array,
         because those elements would be greater than the elements of
         the other array.
         */

        // adding remaining elements of arr1 into mergedArray, if any.
        while (i < arr1.length) {
            mergedArray[k] = arr1[i];
            i++;
            k++;
        }
        // adding remaining elements of arr2 into mergedArray, if any.
        while (j < arr2.length) {
            mergedArray[k] = arr2[j];
            j++;
            k++;
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arr = MargeTwoSortedArray1(new int[]{1,1,8,9,10}, new int[]{1,2,8,9,11,15,16});
        Arrays.stream(arr).forEach(System.out::println);
        MergeSortedArray arrays = new MergeSortedArray();
        int[] arr3 = arrays.mergeArrays(new int[]{0, 3, 4, 31}, new int[]{4, 6, 30});
        System.out.println(Arrays.toString(arr3));
    }
}
