package zero.to.mastery.algorithms.searching;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates depth-first traversal on a binary search tree.
 *
 * <p>
 * Depth-first search (DFS) explores as far as possible down one branch before
 * backtracking. This implementation
 * supports three traversal orders: pre-order, in-order, and post-order. The
 * choice of ordering determines when the
 * node value is added to the result list relative to the left and right
 * subtrees.
 * </p>
 *
 * <p>
 * This class is useful for understanding how tree traversal shapes the output
 * and why different traversal orders
 * are chosen for tasks such as sorting, copying, or evaluating expression
 * trees.
 * </p>
 */
public class DepthFirstSearch {
    /**
     * Enumerates the supported DFS traversal orders.
     */
    enum SearchType {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    private SearchNode node;

    /**
     * Creates an empty tree instance ready for insertion and traversal.
     */
    public DepthFirstSearch() {
        node = null;
    }

    /**
     * Inserts a value into the binary search tree.
     *
     * <p>
     * Smaller values go to the left subtree and larger values go to the right
     * subtree. The operation keeps the tree
     * ordered so lookup and traversal logic continue to work as expected.
     * </p>
     *
     * @param value the integer to insert
     */
    private void insert(int value) {
        SearchNode newNode = new SearchNode(value);
        if (this.node == null) {
            this.node = newNode;
        } else {
            var currentNode = this.node;
            while (true) {
                if (value < currentNode.getValue()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        return;
                    }
                    currentNode = currentNode.getLeft();
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        return;
                    }
                    currentNode = currentNode.getRight();
                }
            }
        }
    }

    /**
     * Looks up a value in the tree using binary-search ordering.
     *
     * <p>
     * Each comparison moves the search left or right depending on whether the
     * target is smaller or larger than the
     * current node. The tree structure makes this lookup efficient in a balanced
     * tree.
     * </p>
     *
     * @param value the value to search for
     * @return the matching node, or null if it is absent
     */
    public SearchNode lookup(int value) {
        if (node == null) {
            return null;
        }
        SearchNode currentNode = node;
        while (currentNode != null) {
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else if (value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else {
                return currentNode;
            }
        }
        return null;
    }

    /**
     * Removes a value from the tree and preserves the binary-search-tree invariant.
     *
     * <p>
     * This example replaces the removed node with the in-order successor or a valid
     * child subtree, so the ordering
     * of all remaining values continues to hold. The method is intentionally
     * compact and educational rather than fully
     * optimized for production-level edge cases.
     * </p>
     *
     * @param value the value to remove
     */
    public void remove(int value) {
        if (node == null) {
            return;
        }

        SearchNode nodeToRemove = node;
        SearchNode parentNode = null;
        while (nodeToRemove.getValue() != value) {
            parentNode = nodeToRemove;
            if (value < nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getLeft();
            } else if (value > nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getRight();
            }
        }

        SearchNode replacementNode = null;
        if (nodeToRemove.getRight() != null) {
            replacementNode = nodeToRemove.getRight();
            if (replacementNode.getLeft() == null) {
                replacementNode.setLeft(nodeToRemove.getLeft());
            } else {
                SearchNode replacementParentNode = nodeToRemove;
                while (replacementNode.getLeft() != null) {
                    replacementParentNode = replacementNode;
                    replacementNode = replacementNode.getLeft();
                }
                replacementParentNode.setLeft(null);
                replacementNode.setLeft(nodeToRemove.getLeft());
                replacementNode.setRight(nodeToRemove.getRight());
            }
        } else if (nodeToRemove.getLeft() != null) {
            replacementNode = nodeToRemove.getLeft();
        }

        if (parentNode == null) {
            node = replacementNode;
        } else if (parentNode.getLeft() == nodeToRemove) {
            parentNode.setLeft(replacementNode);
        } else {
            parentNode.setRight(replacementNode);
        }
    }

    int count = 0;

    /**
     * Prints the tree structure with indentation to make the hierarchy easier to
     * inspect.
     */
    public void printTree() {
        count = 0;
        printTree(node);
    }

    /**
     * Recursively prints the subtree rooted at the supplied node.
     *
     * @param node the current subtree to print
     */
    private void printTree(SearchNode node) {
        System.out.print(node.getValue());
        System.out.println();
        count++;
        if (node.getLeft() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) + "Left: ");
            printTree(node.getLeft());
        }
        if (node.getRight() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) + "Right: ");
            printTree(node.getRight());
        }
        count--;
    }

    /**
     * Traverses the tree in a DFS order chosen by the caller.
     *
     * <p>
     * The method delegates to the recursive helper and allows one of three
     * traversal strategies:
     * </p>
     * <ul>
     * <li>PRE_ORDER: visit node before its children</li>
     * <li>IN_ORDER: visit left subtree, then node, then right subtree</li>
     * <li>POST_ORDER: visit children before node</li>
     * </ul>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * depthFirstSearchInOder(SearchType.IN_ORDER) -> [4, 6, 9, 15, 20]
     * </pre>
     *
     * @param searchType the traversal strategy to use
     * @return the list of visited values in the requested order
     */
    public List<Integer> depthFirstSearchInOder(SearchType searchType) {
        return depthFirstSearchInOder(node, new ArrayList<>(), searchType);
    }

    /**
     * Recursively performs the actual depth-first walk.
     *
     * <p>
     * The only difference between traversal types is when the current node value is
     * appended to the result list.
     * This makes the implementation compact and easy to compare across the three
     * DFS variants.
     * </p>
     *
     * @param node       the current subtree root
     * @param list       the accumulated traversal result
     * @param searchType the chosen traversal order
     * @return the list of values visited in the chosen order
     */
    private List<Integer> depthFirstSearchInOder(SearchNode node, ArrayList<Integer> list, SearchType searchType) {
        if (searchType == SearchType.PRE_ORDER) {
            list.add(node.getValue());
        }
        if (node.getLeft() != null) {
            depthFirstSearchInOder(node.getLeft(), list, searchType);
        }

        if (searchType == SearchType.IN_ORDER) {
            list.add(node.getValue());
        }
        if (node.getRight() != null) {
            depthFirstSearchInOder(node.getRight(), list, searchType);
        }

        if (searchType == SearchType.POST_ORDER) {
            list.add(node.getValue());
        }
        return list;
    }

    /**
     * Builds a sample tree and prints each DFS traversal result for comparison.
     *
     * @param args command-line arguments; not used by this example
     */
    public static void main(String[] args) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.insert(9);
        depthFirstSearch.insert(4);
        depthFirstSearch.insert(6);
        depthFirstSearch.insert(20);
        depthFirstSearch.insert(170);
        depthFirstSearch.insert(15);
        depthFirstSearch.insert(1);
        depthFirstSearch.remove(170);
        depthFirstSearch.printTree();
        System.out.println(
                "Depth first search - in order " + depthFirstSearch.depthFirstSearchInOder(SearchType.IN_ORDER));
        System.out.println(
                "Depth first search - pre order " + depthFirstSearch.depthFirstSearchInOder(SearchType.PRE_ORDER));
        System.out.println(
                "Depth first search - post order " + depthFirstSearch.depthFirstSearchInOder(SearchType.POST_ORDER));
    }
}
