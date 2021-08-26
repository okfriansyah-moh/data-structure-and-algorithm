package zero.to.mastery.data_structures.arrays;

public class SingleDimensionalArray {
    int arr[] = null;

    public SingleDimensionalArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

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
    public void deleteValue(int indexToBeDeleted) {
        try {
            arr[indexToBeDeleted] = Integer.MIN_VALUE;
            System.out.println("Success Deleting");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index Value is not in range");
        }
    }

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
