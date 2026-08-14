package zero.to.mastery.data_structures.linked_list.doubly;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Demonstrates node concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class Node {
    private int value;
    private Node previous;
    private Node next;

    /**
     * Creates a new {@code Node} instance for node operations.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param value input value used by the node process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
