package zero.to.mastery.data_structures.queues.using_linked_list;

import java.util.NoSuchElementException;

/**
 * Demonstrates my queue concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class MyQueue {

  private QueuesNode first;
  private QueuesNode last;
  private int length;

  /**
   * Creates a new {@code MyQueue} instance for my queue operations.
   *
   * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
   * steps defined in this class.</p>
   *
   * Output: initialized object state that is ready for subsequent method calls.
   */
  public MyQueue() {
    first = null;
    last = null;
    length = 0;
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
    if(first == null) {
      throw new NoSuchElementException();
    }
    return first.getValue();
  }

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
    QueuesNode newNode = new QueuesNode(value);
    if(length == 0) {
      first = newNode;
    }
    else {
      last.setNext(newNode);
    }
    last = newNode;
    length++;
  }

  /**
   * Executes dequeue logic.
   *
   * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
   * steps defined in this class.</p>
   *
   * Output: updates internal state and/or prints computed results to the console.
   */
  public void dequeue() {
    if(first == null) {
      throw new NoSuchElementException();
    }
    first = first.getNext();
    length--;
    if(length == 0) {
      last = null;
    }
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
    if(first == null) {
      return;
    }
    QueuesNode currentNode = first;
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
    MyQueue queue = new MyQueue();
    queue.enqueue(3);
    queue.enqueue(5);
    queue.enqueue(5);
    queue.printQueue();
    queue.dequeue();
    queue.printQueue();
    queue.dequeue();
    queue.dequeue();
    queue.printQueue();
  }
}
