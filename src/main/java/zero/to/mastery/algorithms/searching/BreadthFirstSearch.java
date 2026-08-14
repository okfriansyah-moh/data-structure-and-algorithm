package zero.to.mastery.algorithms.searching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Demonstrates breadth-first search on a binary search tree.
 *
 * <p>
 * Breadth-first search (BFS) explores a tree level by level instead of going
 * deep first. It uses a queue to keep
 * track of nodes that need processing, which makes the traversal natural for
 * "visit neighbors before descendants"
 * behavior. This implementation is useful for understanding tree-level ordering
 * and for comparing BFS with DFS.
 * </p>
 *
 * <p>
 * Because the tree is ordered, the insertion logic places smaller values on the
 * left and larger values on the right.
 * BFS can then walk the tree in predictable sequence as it processes each level
 * in turn.
 * </p>
 */
public class BreadthFirstSearch {

    private SearchNode node;

    /**
     * Creates an empty tree ready to accept new values.
     *
     * <p>
     * The root node is initially null until the first inserted value establishes
     * the starting point.
     * </p>
     */
    public BreadthFirstSearch() {
        node = null;
    }

    /**
     * Inserts a new integer value into the binary search tree.
     *
     * <p>
     * The method walks the tree from the root and compares the new value against
     * the current node. Smaller values
     * are placed on the left side, while larger values move to the right. This
     * preserves the binary-search-tree
     * ordering invariant, which is important for later lookup and traversal
     * operations.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * insert(9);
     * insert(4);
     * insert(20);
     * // tree structure: 9 with left 4 and right 20
     * </pre>
     *
     * @param value the integer to insert into the tree
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
     * Finds a node by value in the binary search tree.
     *
     * <p>
     * This method uses the same ordering rule as insertion: values smaller than the
     * current node move left, while
     * larger values move right. If the target is missing, the traversal reaches the
     * end of the tree and returns null.
     * </p>
     *
     * @param value the value to search for
     * @return the matching node if it exists, otherwise null
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
     * Removes a value from the tree.
     *
     * <p>
     * The method searches for the target node, tracks its parent, and replaces it
     * with an appropriate child or
     * successor so the tree remains valid. If the node has both left and right
     * children, the method re-links the
     * leftmost descendant of the right subtree as the replacement to preserve
     * ordering.
     * </p>
     *
     * @param value the value to remove from the tree
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
     * Prints the tree in a simple indented layout to make the structure easier to
     * inspect visually.
     *
     * <p>
     * The method recursively traverses the tree and prefixes each level with
     * indentation, which helps developers see
     * the left/right relationships during debugging or teaching exercises.
     * </p>
     */
    public void printTree() {
        count = 0;
        printTree(node);
    }

    /**
     * Helper method used by {@link #printTree()} to recursively print a subtree.
     *
     * @param node the current subtree root to render
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
     * Traverses the tree using breadth-first search with an explicit queue.
     *
     * <p>
     * BFS visits nodes layer by layer. It starts with the root, then adds left and
     * right children to a queue, and
     * repeats until every node has been processed. This ordering is different from
     * depth-first traversal because BFS
     * explores width before depth.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * breadthFirstSearchIteratively() -> [9, 4, 20, 6, 15]
     * </pre>
     *
     * @return a list containing the tree values in breadth-first order
     */
    public List<Integer> breadthFirstSearchIteratively() {
        SearchNode currentNode = node;
        List<Integer> list = new ArrayList<>();
        Queue<SearchNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            list.add(currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return list;
    }

    /**
     * Traverses the tree using a recursive breadth-first strategy built around a
     * queue.
     *
     * <p>
     * This variant keeps the same output order as the iterative approach, but
     * solves the problem through recursion.
     * A queue is still used to preserve BFS ordering; the recursive call simply
     * repeats the process until the queue is
     * empty. It is included here as a teaching example to contrast recursive and
     * iterative implementations.
     * </p>
     *
     * @return a list containing the tree values in breadth-first order
     */
    public List<Integer> breadthFirstSearchRecursively() {
        Queue<SearchNode> queue = new LinkedList<>();
        queue.add(node);
        return breadthFirstSearchRecursively(queue, new ArrayList<>());
    }

    /**
     * Helper method for the recursive BFS implementation.
     *
     * <p>
     * Each call removes the front of the queue, records the current node value,
     * enqueues its children, and then
     * calls itself again with the remaining queue. The recursion ends once the
     * queue is empty.
     * </p>
     *
     * @param queue the queue holding nodes to process next
     * @param list  the accumulated result set in BFS order
     * @return the values collected during the traversal
     */
    private List<Integer> breadthFirstSearchRecursively(Queue<SearchNode> queue, List<Integer> list) {
        if (queue.isEmpty()) {
            return list;
        }
        SearchNode currentNode = queue.poll();
        list.add(currentNode.getValue());
        if (currentNode.getLeft() != null) {
            queue.add(currentNode.getLeft());
        }

        if (currentNode.getRight() != null) {
            queue.add(currentNode.getRight());
        }
        return breadthFirstSearchRecursively(queue, list);
    }

    /**
     * Demonstrates the BFS traversal on an example tree.
     *
     * @param args command-line arguments; not used by this example
     */
    public static void main(String[] args) {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.insert(9);
        breadthFirstSearch.insert(4);
        breadthFirstSearch.insert(6);
        breadthFirstSearch.insert(20);
        breadthFirstSearch.insert(170);
        breadthFirstSearch.insert(15);
        breadthFirstSearch.insert(1);
        breadthFirstSearch.remove(170);
        breadthFirstSearch.printTree();
        System.out.println("lookup node " + breadthFirstSearch.lookup(20).getValue());
        System.out.println("Breath first search Iterative " + breadthFirstSearch.breadthFirstSearchIteratively());
        System.out.println("Breath first search Recursive " + breadthFirstSearch.breadthFirstSearchRecursively());
    }
}
