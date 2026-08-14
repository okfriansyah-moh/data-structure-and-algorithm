package zero.to.mastery.data_structures.stacks.using_linked_list;

/**
 * Demonstrates stack node concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class StackNode {

  private int value;
  private StackNode next;

  /**
   * Creates a new {@code StackNode} instance for stack node operations.
   *
   * <p>Summary: documents the key steps used by this practice implementation.</p>
   *
   * @param value input value used by the stack node process
   * Output: initialized object state that is ready for subsequent method calls.
   */
  public StackNode(int value) {
    this.value = value;
    this.next = null;
  }

  /**
   * Creates a new {@code StackNode} instance for stack node operations.
   *
   * <p>Summary: documents the key steps used by this practice implementation.</p>
   *
   * @param value input value used by the stack node process
   * @param next input value used by the stack node process
   * Output: initialized object state that is ready for subsequent method calls.
   */
  public StackNode(int value, StackNode next) {
    this.value = value;
    this.next = next;
  }

  /**
   * Executes get value logic.
   *
   * <p>Summary: documents the key steps used by this practice implementation.</p>
   *
   * @return computed int result produced by the get value process
   */
  public int getValue() {
    return value;
  }

  /**
   * Executes set value logic.
   *
   * <p>Summary: documents the key steps used by this practice implementation.</p>
   *
   * @param value input value used by the set value process
   * Output: updates internal state and/or prints computed results to the console.
   */
  public void setValue(int value) {
    this.value = value;
  }

  /**
   * Executes get next logic.
   *
   * <p>Summary: documents the key steps used by this practice implementation.</p>
   *
   * @return computed stack node result produced by the get next process
   */
  public StackNode getNext() {
    return next;
  }

  /**
   * Executes set next logic.
   *
   * <p>Summary: documents the key steps used by this practice implementation.</p>
   *
   * @param next input value used by the set next process
   * Output: updates internal state and/or prints computed results to the console.
   */
  public void setNext(StackNode next) {
    this.next = next;
  }
}
