package zero.to.mastery.data_structures.queues.using_linked_list;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Demonstrates queues node concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class QueuesNode {

  private int value;
  private QueuesNode next;

  /**
   * Creates a new {@code QueuesNode} instance for queues node operations.
   *
   * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
   * steps defined in this class.</p>
   *
   * @param value input value used by the queues node process
   * Output: initialized object state that is ready for subsequent method calls.
   */
  public QueuesNode(int value) {
    this.value = value;
    this.next = null;
  }
}
