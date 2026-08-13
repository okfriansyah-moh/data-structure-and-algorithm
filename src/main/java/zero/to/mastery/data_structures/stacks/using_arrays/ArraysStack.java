package zero.to.mastery.data_structures.stacks.using_arrays;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Demonstrates arrays stack concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class ArraysStack {
    private List<Integer> array = new ArrayList<>();

    /**
     * Creates a new {@code ArraysStack} instance for arrays stack operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public ArraysStack() {
    }

    /**
     * Executes peak logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @return computed int result produced by the peak process
     */
    public int peak() {
        if(array.size() == 0) {
            throw new EmptyStackException();
        }
        return array.get(this.array.size() - 1);
    }

    /**
     * Executes pop logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @return computed int result produced by the pop process
     */
    public int pop() {
        if(array.size() == 0) {
            throw new EmptyStackException();
        }
        return array.remove(array.size() - 1);
    }

    /**
     * Executes push logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param valueToPush input value used by the push process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void push(int valueToPush) {
        array.add(valueToPush);
    }

    /**
     * Executes print stack logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void printStack() {
        for (int value : array) {
            System.out.println(value);
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
        ArraysStack stack = new ArraysStack();
        stack.push(5);
        stack.printStack();
        stack.push(3);
        stack.printStack();
        stack.pop();
        stack.printStack();
    }
}
