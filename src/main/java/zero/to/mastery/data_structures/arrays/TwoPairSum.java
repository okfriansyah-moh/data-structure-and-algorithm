package zero.to.mastery.data_structures.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoPairSum {

    // Given an array of integers, return the
    // indices of the two numbers that add up to
    // a given target

    // Two sum method 1 O(n2)
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

    // method 2 O(n)
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

    // method 3 using hashmap O(n) , space complex = O(n)
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Lgs dicari nih ada gk number to findnya di dalam list nums,
            // kalo ada brarti
            // currentMapValnya gk kosong dan lebih dari 0
            // Makanya bisa lgs return indicesnya
            // else kita store numberToFindnya dah
            var currentMapVal = numsMap.get(nums[i]);
            if (currentMapVal != null && currentMapVal >= 0) {
                return new int[] {currentMapVal, i};
            } else {
                var numberToFind = target - nums[i];
                numsMap.put(numberToFind, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] intArray = {2,7,10,15,11};
        TwoPairSum twoPairSum = new TwoPairSum();
        int[] result = twoPairSum.twoSum3(intArray, 17);
        System.out.println(Arrays.toString(result));
    }
}
