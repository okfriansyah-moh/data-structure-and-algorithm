package zero.to.mastery.data_structures.arrays;

import java.util.Arrays;

/**
 * Demonstrates two dimensional array concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class TwoDimensionalArray {

    int arr[][] = null;

    //Constructor
    /**
     * Creates a new {@code TwoDimensionalArray} instance for two dimensional array operations.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param numberOfRows input value used by the two dimensional array process
     * @param numberOfColumns input value used by the two dimensional array process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public TwoDimensionalArray(int numberOfRows, int numberOfColumns) {
        this.arr = new int[numberOfRows][numberOfColumns];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                arr[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    // inserting value in the array
    /**
     * Executes insert value in the array logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param row input value used by the insert value in the array process
     * @param col input value used by the insert value in the array process
     * @param value input value used by the insert value in the array process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void insertValueInTheArray(int row, int col, int value) {
        try {
            if (arr[row][col] == Integer.MIN_VALUE) {
                arr[row][col] = value;
                System.out.println("Success Insert");
            } else {
                System.out.println("This cell is already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for 2D Array");
        }
    }

    // Accessing cell value from given array
    /**
     * Executes access cell logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param row input value used by the access cell process
     * @param col input value used by the access cell process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void accessCell(int row, int col) {
        System.out.println("Accessing Row " + row + " , Col " + col);
        try {
            System.out.println("Cell Value is " + arr[row][col]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid row index");
        }
    }

    // Traverse 2D Array
    /**
     * Executes traverse2 darray logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void traverse2DArray() {
        for (int row=0; row < arr.length; row++) { // O(mn)
            for (int col = 0; col < arr[0].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Searching a single value from the array
    /**
     * Executes searching value logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param value input value used by the searching value process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void searchingValue(int value) {
        for (int row=0; row < arr.length; row++) { // O(mn)
            for (int col=0; col < arr[0].length; col++) {
                if (arr[row][col] == value) {
                    System.out.println("Value is found at row " + row + " and col " + col);
                    return;
                }
            }
        }
        System.out.println("Value is not found anywhere");
    }

    // Deleting value from array
    /**
     * Executes delete value from array logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param row input value used by the delete value from array process
     * @param col input value used by the delete value from array process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void deleteValueFromArray(int row, int col) {
        try {
            System.out.println("Successfully Deleted : " + arr[row][col]);
            arr[row][col] = Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index is not found");
        }
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
        int[][] int2DArray = new int[2][2];
        int2DArray[0][0] = 1;
        int2DArray[0][1] = 2; // O(mn)

        //All Together is better in case of complexity.
        String s2dArray[][] = {{"a","bb"}, {"c","d"}}; // O(1)

        TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray(5,5);
        twoDimensionalArray.insertValueInTheArray(0,0,10);
        System.out.println(Arrays.deepToString(twoDimensionalArray.arr));
        twoDimensionalArray.accessCell(0,0);
        twoDimensionalArray.traverse2DArray();
        twoDimensionalArray.searchingValue(10);
        twoDimensionalArray.deleteValueFromArray(0,0);
    }
}
