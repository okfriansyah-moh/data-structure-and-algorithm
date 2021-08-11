package zero.to.mastery.data_structures.stacks.using_arrays;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ArraysStack {
    private List<Integer> array = new ArrayList<>();

    public ArraysStack() {
    }

    public int peak() {
        if(array.size() == 0) {
            throw new EmptyStackException();
        }
        return array.get(this.array.size() - 1);
    }

    public int pop() {
        if(array.size() == 0) {
            throw new EmptyStackException();
        }
        return array.remove(array.size() - 1);
    }

    public void push(int valueToPush) {
        array.add(valueToPush);
    }

    public void printStack() {
        for (int value : array) {
            System.out.println(value);
        }
    }

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
