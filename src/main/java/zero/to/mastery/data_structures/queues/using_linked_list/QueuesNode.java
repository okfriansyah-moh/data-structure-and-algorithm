package zero.to.mastery.data_structures.queues.using_linked_list;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QueuesNode {

  private int value;
  private QueuesNode next;

  public QueuesNode(int value) {
    this.value = value;
    this.next = null;
  }
}
