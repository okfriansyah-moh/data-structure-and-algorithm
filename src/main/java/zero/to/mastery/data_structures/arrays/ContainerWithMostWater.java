package zero.to.mastery.data_structures.arrays;

public class ContainerWithMostWater {

    // Cari di dalam array jumlah unit water yg paling gede bisa ditampung

    // using two shifting pointer technique using O(n)
    // The smallest pointer will move through the iteration
    public int maxAreaOptimize(int[] height) {
        int maxArea = 0, p1 = 0, p2 = height.length - 1;
        while (p1 < p2) {
            var minV = Math.min(height[p1], height[p2]);
            var width = p2 - p1;
            var area = minV * width;
            maxArea = Math.max(area, maxArea);
            if (height[p1] <= height[p2]) {
                p1++;
            } else {
                p2--;
            }
        }
        return maxArea;
    }

    // unOptimize way still using O(n2)
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int a = 0; a < height.length; a++) {
            for (int b = a+1; b < height.length; b++) {
                int currentIndexMaxArea = maxArea(height[a], height[b], a, b);
                System.out.println("Current : " + currentIndexMaxArea);
                maxArea = Math.max(maxArea, currentIndexMaxArea);
                System.out.println("Max " + maxArea);
            }
        }
        return maxArea;
    }

    private int maxArea(int a, int b, int indexA, int indexB) {
        System.out.println("a = " + a + " b = " + b + " index A = " + indexA + " index B = " + indexB);
        int minValue = Math.min(a,b);
        System.out.println("min value = " + minValue);
        int indexValue = indexB - indexA;
        System.out.println("index value = " + indexValue);
        return minValue * indexValue;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] intArray = {4,8,1,2,3,9};
        int maxArea = containerWithMostWater.maxAreaOptimize(intArray);
        System.out.println(maxArea);
    }
}
