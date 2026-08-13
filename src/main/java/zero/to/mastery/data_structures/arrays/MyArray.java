package zero.to.mastery.data_structures.arrays;

import java.util.Arrays;

/**
 * Demonstrates my array concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class MyArray {
    private Object[] data;
    private int capacity;
    private int length;

    /**
     * Creates a new {@code MyArray} instance for my array operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public MyArray () {
        capacity = 1;
        length = 0;
        data = new Object[1];
    }

    /**
     * Executes get logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param index input value used by the get process
     * @return computed object result produced by the get process
     */
    public Object get(int index) {
        return data[index];
    }

    /**
     * Executes push logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param obj input value used by the push process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void push(Object obj) {
        if(capacity == length) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
        data[length] = obj;
        length++;
    }

    /**
     * Executes pop logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @return computed object result produced by the pop process
     */
    public Object pop() {
        Object popped = data[length - 1];
        data[length - 1] = null;
        length--;
        return popped;
    }

    /**
     * Executes delete logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param index input value used by the delete process
     * @return computed object result produced by the delete process
     */
    public Object delete(int index) {
        Object itemToDelete = data[index];
        shiftItems(index);
        return itemToDelete;
    }

    /**
     * Executes shift items logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param index input value used by the shift items process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void shiftItems(int index) {
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[length - 1] = null;
        length--;
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
        MyArray m = new MyArray();
        m.push("Hello");
        m.push("World");

        for (int i = 0; i < m.length; i++) {
            System.out.println(m.get(i));
        }
    }
}
