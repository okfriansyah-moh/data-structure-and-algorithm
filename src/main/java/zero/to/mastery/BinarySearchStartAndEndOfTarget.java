package zero.to.mastery;

import java.util.Arrays;

public class BinarySearchStartAndEndOfTarget {
    /**
     * example
     * [1,3,3,5,5,5,8,9] target = 5 , output = [3,5]
     * [1,2,3,4,5,6] target = 4 , output = [3,3]
     * [1,2,3,4,5] t = 9 , output [-1,-1]
     * [] t=3 output [-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        Arrays.sort(nums);
        var firstPos = binarySearch(nums, 0, nums.length, target);
        if (firstPos == -1) return new int[]{-1,-1};
        int endPost = firstPos, startPos = firstPos, temp1 = 0, temp2 = 0;

        while (startPos != -1) {
            temp1 = startPos;
            startPos = binarySearch(nums, 0, startPos - 1, target);
        }
        startPos = temp1;

        while (endPost != -1) {
            temp2 = endPost;
            endPost = binarySearch(nums, endPost = 1, nums.length -1, target);
        }
        endPost = temp2;
        return new int[]{startPos,endPost};
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            var mid = (int) (Math.floor((left=right)/2));
            var foundVal = nums[mid];
            if (foundVal == target) {
                return mid;
            } else if (foundVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
