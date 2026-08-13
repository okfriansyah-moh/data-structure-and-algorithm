package zero.to.mastery.data_structures.arrays;

/**
 * Demonstrates single dimensional array concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class SingleDimensionalArray {
    int arr[] = null;

    /**
     * Creates a new {@code SingleDimensionalArray} instance for single dimensional array operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param sizeOfArray input value used by the single dimensional array process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public SingleDimensionalArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    /**
     * Executes insert logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param location input value used by the insert process
     * @param valueToBeInserted input value used by the insert process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void insert(int location, int valueToBeInserted) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = valueToBeInserted;
                System.out.println("Success insert");
            } else {
                System.out.println("This cell already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("invalid index to access the array");
        }
    }

    // Array traversal
    /**
     * Executes traverse array logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void traverseArray() {
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        } catch (Exception e) {
            System.out.println("Array does not exist");
        }
    }

    // search for an array element in the given array
    /**
     * Executes search in array logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param valueToSearch input value used by the search in array process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void searchInArray(int valueToSearch) {
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == valueToSearch) {
                System.out.println("Value is found at the index of " + i);
                return;
            }
        }
        System.out.println("Value is not found anywhere");
    }

    // Delete value from array
    /**
     * Executes delete value logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param indexToBeDeleted input value used by the delete value process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void deleteValue(int indexToBeDeleted) {
        try {
            arr[indexToBeDeleted] = Integer.MIN_VALUE;
            System.out.println("Success Deleting");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index Value is not in range");
        }
    }

    /**
     * Executes main logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        SingleDimensionalArray singleDimensionalArray = new SingleDimensionalArray(10);
        singleDimensionalArray.insert(0,0);
        singleDimensionalArray.insert(1, 100);
        singleDimensionalArray.insert(1, 20);
        singleDimensionalArray.insert(2, 30);
        singleDimensionalArray.insert(3, 40);
        singleDimensionalArray.insert(101,2);
        System.out.println(singleDimensionalArray.arr[1]);
        singleDimensionalArray.traverseArray();
        System.out.println("");
        singleDimensionalArray.searchInArray(30);
        singleDimensionalArray.searchInArray(10);
        singleDimensionalArray.deleteValue(0);
        singleDimensionalArray.traverseArray();
        singleDimensionalArray.deleteValue(20);
    }
}
