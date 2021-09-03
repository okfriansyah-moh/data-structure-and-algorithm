package zero.to.mastery.data_structures.arrays;

import java.util.Arrays;

public class GetMiddleDataInArray {
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(middle(intArray)));
    }

    static int[] middle(int[] arr) {
        return Arrays.copyOfRange(arr, 1, arr.length-1);
    }
}
