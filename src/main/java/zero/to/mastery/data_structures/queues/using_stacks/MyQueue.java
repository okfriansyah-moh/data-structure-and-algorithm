package zero.to.mastery.data_structures.queues.using_stacks;

import java.util.Stack;

/**
 * Demonstrates my queue concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class MyQueue {
  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> auxiliaryStack = new Stack<>();

  /**
   * Executes enqueue logic.
   *
   * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
   * steps defined in this class.</p>
   *
   * @param value input value used by the enqueue process
   * Output: updates internal state and/or prints computed results to the console.
   */
  public void enqueue(int value) {
    stack.push(value);
  }

  /**
   * Executes dequeue logic.
   *
   * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
   * steps defined in this class.</p>
   *
   * @return computed int result produced by the dequeue process
   */
  public int dequeue() {
    fillAuxiliaryStackWithStack();
    int value = auxiliaryStack.pop();
    fillStackWithAuxiliaryStack();
    return value;
  }

  /**
   * Executes peek logic.
   *
   * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
   * steps defined in this class.</p>
   *
   * @return computed int result produced by the peek process
   */
  public int peek() {
   fillAuxiliaryStackWithStack();
    int value = auxiliaryStack.peek();
    fillStackWithAuxiliaryStack();
    return value;
  }

  /**
   * Executes print queue logic.
   *
   * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
   * steps defined in this class.</p>
   *
   * Output: updates internal state and/or prints computed results to the console.
   */
  public void printQueue() {
    if (stack.empty()) {
      return;
    }

    fillAuxiliaryStackWithStack();
    Object[] list = auxiliaryStack.toArray();
    for (Object o : list) {
      System.out.print("-->" + o);
    }
    System.out.println();
   fillStackWithAuxiliaryStack();
  }

  /**
   * Executes fill auxiliary stack with stack logic.
   *
   * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
   * steps defined in this class.</p>
   *
   * Output: updates internal state and/or prints computed results to the console.
   */
  private void fillAuxiliaryStackWithStack() {
    while (!stack.isEmpty()) { //Making the "auxiliaryStack" stack as queue of "Stack"
      auxiliaryStack.push(stack.pop());
    }
  }

  /**
   * Executes fill stack with auxiliary stack logic.
   *
   * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
   * steps defined in this class.</p>
   *
   * Output: updates internal state and/or prints computed results to the console.
   */
  private void fillStackWithAuxiliaryStack() {
    while (!auxiliaryStack.isEmpty()) { //Return stack to the original state
      stack.push(auxiliaryStack.pop());
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
    MyQueue queue = new MyQueue();
    queue.enqueue(10);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.printQueue();
    queue.dequeue();
    queue.printQueue();
    queue.dequeue();
    queue.printQueue();
  }
}

