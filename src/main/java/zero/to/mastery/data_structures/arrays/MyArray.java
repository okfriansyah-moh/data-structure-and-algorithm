package zero.to.mastery.data_structures.arrays;

import java.util.Arrays;

/**
 * A dynamic array implementation that mimics the behavior of JavaScript arrays or ArrayList.
 * This class demonstrates how arrays grow dynamically in memory when they reach capacity.
 * 
 * <p><b>Key Concepts:</b></p>
 * <ul>
 *   <li>Dynamic resizing when capacity is exceeded</li>
 *   <li>O(1) access time for get operations by index</li>
 *   <li>O(n) time for delete/shift operations due to shifting elements</li>
 *   <li>Amortized O(1) for push operations</li>
 * </ul>
 * 
 * <p><b>Example:</b></p>
 * <pre>
 * MyArray arr = new MyArray();
 * arr.push("Hello");      // Array grows from capacity 1 to 2 internally
 * arr.push("World");      // Array size is now 2
 * Object first = arr.get(0);  // Returns "Hello"
 * arr.delete(0);          // Removes "Hello", shifts "World" to index 0
 * </pre>
 */
public class MyArray {
    private Object[] data;      // Underlying storage array
    private int capacity;       // Current capacity (total slots available)
    private int length;         // Current number of elements stored

    /**
     * Initializes a new MyArray with initial capacity of 1.
     * The array will automatically double in size when it becomes full.
     * 
     * <p><b>Initial state:</b></p>
     * <ul>
     *   <li>capacity = 1 (one empty slot)</li>
     *   <li>length = 0 (no elements yet)</li>
     *   <li>data = new Object[1] (internal storage)</li>
     * </ul>
     * 
     * <p><b>Example:</b></p>
     * <pre>
     * MyArray myArr = new MyArray();  // Creates array with [null]
     * </pre>
     */
    public MyArray () {
        capacity = 1;
        length = 0;
        data = new Object[1];
    }

    /**
     * Retrieves an element at the specified index.
     * This is a direct array lookup with O(1) constant time complexity.
     *
     * <p><b>How it works:</b></p>
     * <p>Simply accesses the underlying data array at the given index. No shifting or 
     * traversal is needed, making this operation very fast regardless of array size.</p>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * MyArray arr = new MyArray();
     * arr.push("Apple");
     * arr.push("Banana");
     * Object fruit = arr.get(0);  // Returns "Apple" instantly
     * Object fruit2 = arr.get(1); // Returns "Banana" instantly
     * </pre>
     *
     * @param index the position of the element to retrieve (0-based)
     * @return the element stored at the specified index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    public Object get(int index) {
        return data[index];
    }

    /**
     * Adds an element to the end of the array (append operation).
     * If the array is full, it automatically doubles its capacity before adding.
     * Time complexity: Amortized O(1) - most operations are O(1), with occasional O(n) for resizing.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Check if current capacity equals current length (array is full)</li>
     *   <li>If full: double the capacity and copy all elements to new larger array</li>
     *   <li>Store the object at index <code>length</code></li>
     *   <li>Increment length counter</li>
     * </ol>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * MyArray arr = new MyArray();  // capacity=1, length=0
     * arr.push("First");             // capacity still 1, length=1 (array: ["First"])
     * arr.push("Second");            // capacity becomes 2, length=2 (array: ["First", "Second"])
     * arr.push("Third");             // capacity becomes 4, length=3 (array: ["First", "Second", "Third", null])
     * </pre>
     *
     * @param obj the element to add to the end of the array
     */
    public void push(Object obj) {
        if(capacity == length) {
            // Array is full, double its size and copy all elements
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
        data[length] = obj;
        length++;
    }

    /**
     * Removes and returns the last element from the array.
     * Time complexity: O(1) - simply removes the last element without shifting.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Retrieve the element at index (length - 1)</li>
     *   <li>Set that position to null (cleanup)</li>
     *   <li>Decrement the length counter</li>
     *   <li>Return the removed element</li>
     * </ol>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * MyArray arr = new MyArray();
     * arr.push("Alice");
     * arr.push("Bob");
     * arr.push("Charlie");
     * Object last = arr.pop();  // Returns "Charlie", array becomes ["Alice", "Bob"]
     * Object last2 = arr.pop(); // Returns "Bob", array becomes ["Alice"]
     * </pre>
     *
     * @return the element that was removed from the end of the array
     * @throws ArrayIndexOutOfBoundsException if array is empty
     */
    public Object pop() {
        Object popped = data[length - 1];
        data[length - 1] = null;  // Clear reference for garbage collection
        length--;
        return popped;
    }

    /**
     * Removes an element at a specific index and returns it.
     * Time complexity: O(n) - requires shifting all elements after the deleted item.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Store the element to be deleted</li>
     *   <li>Call {@link #shiftItems(int)} to shift all elements after the index one position left</li>
     *   <li>Return the deleted element</li>
     * </ol>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * MyArray arr = new MyArray();
     * arr.push(10);
     * arr.push(20);
     * arr.push(30);
     * arr.push(40);
     * // Array: [10, 20, 30, 40]
     * Object removed = arr.delete(1);  // Removes 20
     * // Array becomes: [10, 30, 40]
     * // Returns: 20
     * </pre>
     *
     * @param index the position of the element to remove (0-based)
     * @return the element that was deleted
     */
    public Object delete(int index) {
        Object itemToDelete = data[index];
        shiftItems(index);  // Shift everything after this index to the left
        return itemToDelete;
    }

    /**
     * Shifts all elements to the left starting from a given index.
     * This is a helper method used internally by {@link #delete(int)}.
     * Time complexity: O(n) - must move all elements after the index one position left.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Loop from the given index to length - 2</li>
     *   <li>Move each element from position i+1 to position i (shift left)</li>
     *   <li>Set the last position to null (cleanup)</li>
     *   <li>Decrement length</li>
     * </ol>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * Before: [10, 20, 30, 40] (length=4, index=1)
     * Step 1: [10, 30, 30, 40] (copy 30 to position 1)
     * Step 2: [10, 30, 40, 40] (copy 40 to position 2)
     * After:  [10, 30, 40, null] (length=3, last position cleared)
     * </pre>
     *
     * @param index the starting position from which to begin shifting elements left
     */
    public void shiftItems(int index) {
        // Move each element one position to the left
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[length - 1] = null;  // Clear the last position
        length--;  // Update the length counter
    }

    /**
     * Demonstrates the core functionality of the MyArray class with practical usage.
     * This main method shows how to create an array, add elements, and retrieve them.
     *
     * <p><b>Output:</b></p>
     * <pre>
     * Hello
     * World
     * </pre>
     *
     * @param args command-line arguments (not used in this example)
     */
    public static void main(String[] args) {
        MyArray m = new MyArray();
        m.push("Hello");    // Add "Hello" to the array
        m.push("World");    // Add "World" to the array

        // Print each element in the array
        for (int i = 0; i < m.length; i++) {
            System.out.println(m.get(i));
        }
    }
}
