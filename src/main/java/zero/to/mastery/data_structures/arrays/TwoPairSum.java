package zero.to.mastery.data_structures.arrays;

import java.util.Arrays;

public class TwoPairSum {

    // Two sum method 1
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No Solution Found");
    }

    // method 2
    public int[] twoSum2(int[] nums, int target) {
        // TODO
        int temp = 0;
        int count = 0;
        int[] result = new int[2];
        for (int i : nums) {
            if (temp + i == target) {
                result[0] = count - 1;
                result[1] = count;
                break;
            }
            temp = i;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] intArray = {2,7,11,15};
        TwoPairSum twoPairSum = new TwoPairSum();
        int[] result = twoPairSum.twoSum2(intArray, 26);
        System.out.println(Arrays.toString(result));
    }
}
