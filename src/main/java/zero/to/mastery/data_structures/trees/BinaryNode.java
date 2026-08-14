package zero.to.mastery.data_structures.trees;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Demonstrates binary node concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class BinaryNode {
    private int value;
    private BinaryNode left;
    private BinaryNode right;

    /**
     * Creates a new {@code BinaryNode} instance for binary node operations.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
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
