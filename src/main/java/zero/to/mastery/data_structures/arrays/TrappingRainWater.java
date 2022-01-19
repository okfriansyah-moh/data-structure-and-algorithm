package zero.to.mastery.data_structures.arrays;

public class TrappingRainWater {



    // unOptimize solution using for loop all
    public int trap(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int maxLeft = maxLeftFor(height,i);
            System.out.println("Max left = " + maxLeft);
            int maxRight = maxRightFor(height,i);
            System.out.println("Max Right = " + maxRight);
            int minRightLeft = Math.min(maxLeft,maxRight);
            System.out.println("Min rightLeft = " + minRightLeft);
            int currentResult = minRightLeft - height[i] < 0 ? 0 : minRightLeft - height[i];
            System.out.println("Current Result = " + currentResult);
            result += currentResult;
            System.out.println("Total Result = " + result);
        }
        return result;
    }

    // unOptimize solution using for loop and while loop
    public int trap2(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int leftP = i, rightP = i, maxLeft = 0, maxRight = 0;
            maxRight = maxRightWhile(rightP, height);
            System.out.println("Max Right = " + maxRight);
            maxLeft = maxLeftWhile(leftP, height);
            System.out.println("Max left = " + maxLeft);
            var currentWater = Math.min(maxLeft, maxRight) - height[i];
            System.out.println("Current Water = " + currentWater);
            if (currentWater >= 0) {
                result += currentWater;
            }
        }
        return result;
    }

    // using for loop
    private int maxRightFor(int[] height, int startingIndex) {
        int result = 0;
        for (int i = startingIndex; i < height.length; i++) {
            System.out.println("iteration right = " + i);
            result = Math.max(result,height[i]);
            System.out.println("Result right = " + result);
        }
        return result;
    }

    //using while loop
    private int maxRightWhile(int rightP, int [] heigth) {
        int maxRight = 0;
        while (rightP < heigth.length) {
            maxRight = Math.max(maxRight, heigth[rightP]);
            rightP++;
        }
        return maxRight;
    }

    // using for loop
    private int maxLeftFor(int[] height, int startingIndex) {
        if (startingIndex == 0) return 0;
        int result = 0;
        for (int i = 0; i < startingIndex; i++) {
            System.out.println("iteration left = " + i);
            result = Math.max(result,height[i]);
            System.out.println("Result left = " + result);
        }
        return result;
    }

    //using while loop
    private int maxLeftWhile(int leftP, int [] heigth) {
        int maxLeft = 0;
        while (leftP >= 0) {
            maxLeft = Math.max(maxLeft, heigth[leftP]);
            leftP--;
        }
        return maxLeft;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] intArray = {5,0,3,0,0,0,2,3,4,2,1};
        int totalWater = trappingRainWater.trap2(intArray);
        System.out.println(totalWater);
    }
}
