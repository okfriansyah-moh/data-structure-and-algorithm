package zero.to.mastery.data_structures.linked_list.doubly;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Demonstrates node concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class Node {
    private int value;
    private Node previous;
    private Node next;

    /**
     * Creates a new {@code Node} instance for node operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param value input value used by the node process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
