package zero.to.mastery.data_structures.linked_list.singly;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Demonstrates my singly linked node concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class MySinglyLinkedNode {
    private int value;
    private MySinglyLinkedNode next;

    /**
     * Creates a new {@code MySinglyLinkedNode} instance for my singly linked node operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param value input value used by the my singly linked node process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public MySinglyLinkedNode(int value) {
        this.value = value;
        this.next = null;
    }
}
