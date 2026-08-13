package zero.to.mastery.data_structures.queues.using_stacks;

import java.util.Stack;

/**
 * Demonstrates my queue concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class MyQueue {
  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> auxiliaryStack = new Stack<>();

  /**
   * Executes enqueue logic.
   *
   * <p>Summary: documents the key steps used by this practice implementation.</p>
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
   * <p>Summary: documents the key steps used by this practice implementation.</p>
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
   * <p>Summary: documents the key steps used by this practice implementation.</p>
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
   * <p>Summary: documents the key steps used by this practice implementation.</p>
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
   * <p>Summary: documents the key steps used by this practice implementation.</p>
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
   * <p>Summary: documents the key steps used by this practice implementation.</p>
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
   * <p>Summary: documents the key steps used by this practice implementation.</p>
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

