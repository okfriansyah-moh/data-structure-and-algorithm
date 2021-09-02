package zero.to.mastery.data_structures.arrays;

import java.util.Arrays;

public class RotateMatrix90d {
    public static void main(String[] args) {
        RotateMatrix90d rotateMatrix90d = new RotateMatrix90d();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotateMatrix90d.rotate90d(matrix);
    }
    // Leet code rotate image
    // Given an image represented by an NxN matrix.
    // Write a method to rotate the image by 90 degrees
    // Example :
    // 1   2   3
    // 4   5   6
    // 7   8   9
    // The step will be rotating outermost layer : we have to move the edge first
    // 1 move to 3, 3 move to 9, 9 move to 7, 7 move to 1
    // So it will be like this
    // 7   2   1
    // 4   5   6
    // 9   8   3
    // All is left is the second layer or inner most , 2 , 6, 8, 4.
    // We can implement the same logic swapping.
    // The Output will be :
    // 7   4   1
    // 8   5   2
    // 9   6   3
    // Input matrix = [[1,2,3], [4,5,6], [7,8,9]]
    // Output = [[7,4,1],[8,5,2],[9,6,3]]
    public boolean rotate90d(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
        // check if matrix is non an NxN
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        // get the number of rows to get the number of layers.
        // Like 3 x 3 is composed of 2 layers. inner and outer.
        int n = matrix.length;
        // loop will start from layer zero, and loop through number of layer.
        // Number of layer is n/2
        // First loop is for looping through layer
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            // So then we are going change their places.
            // Second loop is to loop through the cells
            for (int i = first; i < last; i++) {
                // offset is helper variable to get the offset
                int offset = i - first;
                int top = matrix[first][i];
                // move left cell to the top
                // left cell is located at the last row and first column
                matrix[first][i] = matrix[last-offset][first];
                // move bottom cell to the left
                // bottom cell is located at the last column and last row
                matrix[last-offset][first] = matrix[last][last-offset];
                // next we have to move right cell to the bottom
                // right cell is located at the first row and last column
                matrix[last][last-offset] = matrix[i][last];
                // lastly we move top cell to the right cell
                matrix[i][last] = top;
            }
        }
        // to print 2 D array use deepToString
        System.out.println(Arrays.deepToString(matrix));
        return true;
    }
}
