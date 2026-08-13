package zero.to.mastery.algorithms.searching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Demonstrates breadth first search concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class BreadthFirstSearch {

    private SearchNode node;

    /**
     * Creates a new {@code BreadthFirstSearch} instance for breadth first search operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public BreadthFirstSearch() {
        node = null;
    }

    // insert process in video
    /**
     * Executes insert logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param value input value used by the insert process
     * Output: updates internal state and/or prints computed results to the console.
     */
    private void insert(int value) {
        SearchNode newNode = new SearchNode(value);
        if (this.node == null) {
            this.node = newNode;
        } else {
            var currentNode = this.node;
            while (true) {
                if (value < currentNode.getValue()) {
                    // left
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        return;
                    }
                    currentNode = currentNode.getLeft();
                } else {
                    // right
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
     * Executes lookup logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param value input value used by the lookup process
     * @return computed search node result produced by the lookup process
     */
    public SearchNode lookup(int value) {
        if(node == null) {
            return null;
        }
        SearchNode currentNode = node;
        while (currentNode != null) {
            if(value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else if(value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else {
                return currentNode;
            }
        }
        return null;
    }

    /**
     * Executes remove logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param value input value used by the remove process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void remove(int value) {
        if (node == null) {
            return;
        }

        SearchNode nodeToRemove = node;
        SearchNode parentNode = null;
        while (nodeToRemove.getValue() != value) { //Searching for the node to remove and it's parent
            parentNode = nodeToRemove;
            if (value < nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getLeft();
            } else if (value > nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getRight();
            }
        }

        SearchNode replacementNode = null;
        if (nodeToRemove.getRight() != null) { //We have a right node
            replacementNode = nodeToRemove.getRight();
            if(replacementNode.getLeft() == null) { //We don't have a left node
                replacementNode.setLeft(nodeToRemove.getLeft());
            } else { //We have a have a left node, lets find the leftmost
                SearchNode replacementParentNode = nodeToRemove;
                while (replacementNode.getLeft() != null) {
                    replacementParentNode = replacementNode;
                    replacementNode = replacementNode.getLeft();
                }
                replacementParentNode.setLeft(null);
                replacementNode.setLeft(nodeToRemove.getLeft());
                replacementNode.setRight(nodeToRemove.getRight());
            }
        } else if(nodeToRemove.getLeft() != null) {//We only have a left node
            replacementNode = nodeToRemove.getLeft();
        }

        if(parentNode == null) {
            node = replacementNode;
        } else if(parentNode.getLeft() == nodeToRemove) { //We are a left child
            parentNode.setLeft(replacementNode);
        } else { //We are a right child
            parentNode.setRight(replacementNode);
        }
    }

    int count = 0;
    /**
     * Executes print tree logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void printTree() {
        count = 0;
        printTree(node);
    }

    /**
     * Executes print tree logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param node input value used by the print tree process
     * Output: updates internal state and/or prints computed results to the console.
     */
    private void printTree(SearchNode node) {
        System.out.print(node.getValue());
        System.out.println();
        count++;
        if(node.getLeft() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) + "Left: ");
            printTree(node.getLeft());
        }
        if(node.getRight() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) +"Right: ");
            printTree(node.getRight());
        }
        count--;
    }

    // BFS
    /**
     * Executes breadth first search iteratively logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @return computed list<integer> result produced by the breadth first search iteratively process
     */
    public List<Integer> breadthFirstSearchIteratively() {
        SearchNode currentNode = node;
        List<Integer> list = new ArrayList<>();
        // this queue can get pretty large, because we have to keep reference of our child node.
        Queue<SearchNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            // Retrieves and removes the head of this queue, or returns null if this queue is empty.
            // Returns: the head of this queue, or null if this queue is empty
            currentNode = queue.poll();
            list.add(currentNode.getValue()); // first value
            // does the first value have a left child. If it does, add it to the queue
            if(currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft()); // We keep adding to the queue, it can get space complexity if we have a wide tree
            }
            // after it check left, we check right as the second item. If it has a value, add to queue.
            // Same like BFS pattern. Level per level
            if(currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return list;
    }

    /**
     * Executes breadth first search recursively logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @return computed list<integer> result produced by the breadth first search recursively process
     */
    public List<Integer> breadthFirstSearchRecursively() {
        Queue<SearchNode> queue = new LinkedList<>();
        queue.add(node);
        return breadthFirstSearchRecursively(queue, new ArrayList<>());
    }

    /**
     * Executes breadth first search recursively logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param queue input value used by the breadth first search recursively process
     * @param list input value used by the breadth first search recursively process
     * @return computed list<integer> result produced by the breadth first search recursively process
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
     * Executes main logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
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
