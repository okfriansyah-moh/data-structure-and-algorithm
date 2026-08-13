package zero.to.mastery.data_structures.trees;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Demonstrates binary node concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class BinaryNode {
    private int value;
    private BinaryNode left;
    private BinaryNode right;

    /**
     * Creates a new {@code BinaryNode} instance for binary node operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param value input value used by the binary node process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public BinaryNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
