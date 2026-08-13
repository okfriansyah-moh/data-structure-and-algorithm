package zero.to.mastery.data_structures.stacks.using_linked_list;

import java.util.EmptyStackException;

/**
 * Demonstrates linked list stack concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class LinkedListStack {
  private StackNode top;
  private StackNode bottom;
  private int length;

  /**
   * Creates a new {@code LinkedListStack} instance for linked list stack operations.
   *
   * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
   * steps defined in this class.</p>
   *
   * Output: initialized object state that is ready for subsequent method calls.
   */
  public LinkedListStack() {
    top = null;
    bottom = null;
    length = 0;
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
    if(length == 0) {
      throw new EmptyStackException();
    }
    return top.getValue();
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
    if(length == 0) {
      throw new EmptyStackException();
    }
    StackNode tempTop = top;
    top = top.getNext();
    length--;
    if(length == 0) {
      bottom = null;
    }
    return tempTop.getValue();
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
    top = new StackNode(valueToPush, top);
    if(length == 0) {
      bottom = top;
    }
    length++;
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
    if(top == null) {
      return;
    }
    StackNode currentNode = top;
    System.out.print(currentNode.getValue());
    currentNode = currentNode.getNext();
    while (currentNode != null) {
      System.out.print("-->" + currentNode.getValue());
      currentNode = currentNode.getNext();
    }
    System.out.println();
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
    LinkedListStack stack = new LinkedListStack();
    stack.push(5);
    stack.printStack();
    stack.push(3);
    stack.printStack();
    stack.pop();
    stack.pop();
    stack.printStack();
  }
}
