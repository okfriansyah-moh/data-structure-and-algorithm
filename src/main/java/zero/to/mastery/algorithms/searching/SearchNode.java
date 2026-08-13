package zero.to.mastery.algorithms.searching;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Demonstrates search node concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class SearchNode {
    private int value;
    private SearchNode left;
    private SearchNode right;

    /**
     * Creates a new {@code SearchNode} instance for search node operations.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param value input value used by the search node process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public SearchNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
