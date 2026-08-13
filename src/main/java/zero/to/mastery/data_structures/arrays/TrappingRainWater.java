package zero.to.mastery.data_structures.arrays;

/**
 * Demonstrates trapping rain water concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class TrappingRainWater {

    // optimize using two pointers technique
    // The two point technique was where we initialized
    // some pointer on the left and some points are on the right,
    // and then we conditionally try to figure out
    // what rationale was there for us to move one of these
    // pointers inwards.
    // And while we were moving them inwards,
    // we were collecting some information that we had determined based
    // on our equation.
    /**
     * Executes trap3 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param height input value used by the trap3 process
     * @return computed int result produced by the trap3 process
     */
    public int trap3(int[] height) {
        int currentWater = 0,
                maxLeft = 0,
                maxRight = 0, p1 = 0, p2 = height.length - 1;
        while (p1 < p2) {
            if (height[p1] <= height[p2]) {
                maxLeft = Math.max(maxLeft,height[p1]);
                currentWater += maxLeft - height[p1];
                p1++;
            } else {
                maxRight = Math.max(maxRight,height[p2]);
                currentWater += maxRight - height[p2];
                p2--;
            }

        }
        return currentWater;
    }

    /**
     * Executes trap4 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param height input value used by the trap4 process
     * @return computed int result produced by the trap4 process
     */
    public int trap4(int[] height) {
        int currentWater = 0,
                maxLeft = 0,
                maxRight = 0, p1 = 0, p2 = height.length - 1;
        while (p1 < p2) {
            if (height[p1] <= height[p2]) {
                if (height[p1] >= maxLeft) {
                    maxLeft = height[p1];
                } else {
                    currentWater += maxLeft - height[p1];
                }
                p1++;
            } else {
                if (height[p2] >= maxRight) {
                    maxRight = height[p2];
                } else {
                    currentWater += maxRight - height[p2];
                }
                p2--;
            }

        }
        return currentWater;
    }

    // unOptimize solution using for loop all
    /**
     * Executes trap logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param height input value used by the trap process
     * @return computed int result produced by the trap process
     */
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
    /**
     * Executes trap2 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param height input value used by the trap2 process
     * @return computed int result produced by the trap2 process
     */
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
    /**
     * Executes max right for logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param height input value used by the max right for process
     * @param startingIndex input value used by the max right for process
     * @return computed int result produced by the max right for process
     */
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
    /**
     * Executes max right while logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param rightP input value used by the max right while process
     * @param heigth input value used by the max right while process
     * @return computed int result produced by the max right while process
     */
    private int maxRightWhile(int rightP, int [] heigth) {
        int maxRight = 0;
        while (rightP < heigth.length) {
            maxRight = Math.max(maxRight, heigth[rightP]);
            rightP++;
        }
        return maxRight;
    }

    // using for loop
    /**
     * Executes max left for logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param height input value used by the max left for process
     * @param startingIndex input value used by the max left for process
     * @return computed int result produced by the max left for process
     */
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
    /**
     * Executes max left while logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param leftP input value used by the max left while process
     * @param heigth input value used by the max left while process
     * @return computed int result produced by the max left while process
     */
    private int maxLeftWhile(int leftP, int [] heigth) {
        int maxLeft = 0;
        while (leftP >= 0) {
            maxLeft = Math.max(maxLeft, heigth[leftP]);
            leftP--;
        }
        return maxLeft;
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
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] intArray = {5,0,3,0,0,0,2,3,4,2,1};
        int totalWater = trappingRainWater.trap3(intArray);
        System.out.println(totalWater);
        System.out.println(Math.floor(2.5));
    }
}
