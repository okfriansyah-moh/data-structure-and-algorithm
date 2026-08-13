package zero.to.mastery.algorithms.searching;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates depth first search concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class DepthFirstSearch {
    /**
     * Demonstrates search type concepts for data-structure and algorithm practice.
     *
     * <p>Use this class as a quick reference for the core algorithm flow.</p>
     */
    enum SearchType {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    private SearchNode node;

    /**
     * Creates a new {@code DepthFirstSearch} instance for depth first search operations.
     *
     * <p>Explanation: initializes an empty binary-search-tree container that can be populated
     * and traversed with DFS variants.</p>
     *
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public DepthFirstSearch() {
        node = null;
    }

    // insert process in video
    /**
     * Executes insert logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
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
     * <p>Summary: documents the key steps used by this practice implementation.</p>
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
     * <p>Summary: documents the key steps used by this practice implementation.</p>
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
     * <p>Summary: documents the key steps used by this practice implementation.</p>
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
     * <p>Summary: documents the key steps used by this practice implementation.</p>
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

    // DFS Most of the time used recursive
    /**
     * Executes depth first search in oder logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param searchType input value used by the depth first search in oder process
     * @return computed list<integer> result produced by the depth first search in oder process
     */
    public List<Integer> depthFirstSearchInOder(SearchType searchType) {
        return depthFirstSearchInOder(node, new ArrayList<>(), searchType);
    }

    // Bedanya cuma di posisi dimana list.add nya aja untuk masing2 tipe dfs.
    // Kalo pre order di add sebelum left
    // Kalo in order di add setelah left dan sebelum right
    // Kalo post order di add setelah semuanya, left dan right
    /**
     * Executes depth first search in oder logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param node input value used by the depth first search in oder process
     * @param list input value used by the depth first search in oder process
     * @param searchType input value used by the depth first search in oder process
     * @return computed list<integer> result produced by the depth first search in oder process
     */
    private List<Integer> depthFirstSearchInOder(SearchNode node, ArrayList<Integer> list, SearchType searchType) {

        if(searchType == SearchType.PRE_ORDER) {
            list.add(node.getValue());
        }
        if(node.getLeft() != null) {
            depthFirstSearchInOder(node.getLeft(), list, searchType);
        }

        if(searchType == SearchType.IN_ORDER) {
            list.add(node.getValue());
        }
        if(node.getRight() != null) {
            depthFirstSearchInOder(node.getRight(), list, searchType);
        }

        if(searchType == SearchType.POST_ORDER) {
            list.add(node.getValue());
        }
        return list;
    }

    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
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
        System.out.println("Depth first search - in order " + depthFirstSearch.depthFirstSearchInOder(SearchType.IN_ORDER));
        System.out.println("Depth first search - pre order " + depthFirstSearch.depthFirstSearchInOder(SearchType.PRE_ORDER));
        System.out.println("Depth first search - post order " + depthFirstSearch.depthFirstSearchInOder(SearchType.POST_ORDER));
    }
}
