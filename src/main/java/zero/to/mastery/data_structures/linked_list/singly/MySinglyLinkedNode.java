package zero.to.mastery.data_structures.linked_list.singly;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Demonstrates my singly linked node concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class MySinglyLinkedNode {
    private int value;
    private MySinglyLinkedNode next;

    /**
     * Creates a new {@code MySinglyLinkedNode} instance for my singly linked node operations.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param value input value used by the my singly linked node process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public MySinglyLinkedNode(int value) {
        this.value = value;
        this.next = null;
    }
}
