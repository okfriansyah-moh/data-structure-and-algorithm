package zero.to.mastery.algorithms.searching;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Represents a single node inside a binary search tree.
 *
 * <p>
 * Each node stores an integer value and references to its left and right
 * children. This simple structure is
 * the foundation for binary-tree traversal and searching algorithms such as
 * breadth-first search (BFS) and
 * depth-first search (DFS).
 * </p>
 *
 * <p>
 * Binary search trees maintain the invariant that every value in the left
 * subtree is smaller than the parent,
 * while every value in the right subtree is greater than or equal to the
 * parent. That ordering enables quick lookup,
 * insertion, and deletion operations.
 * </p>
 */
public class SearchNode {
    private int value;
    private SearchNode left;
    private SearchNode right;

    /**
     * Creates a new node with a value and no children.
     *
     * <p>
     * This constructor is used when a new integer is inserted into a binary search
     * tree. As the tree grows,
     * the node is placed on the left or right side depending on its value relative
     * to the current parent.
     * </p>
     *
     * @param value the numeric value stored in the node
     */
    public SearchNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
