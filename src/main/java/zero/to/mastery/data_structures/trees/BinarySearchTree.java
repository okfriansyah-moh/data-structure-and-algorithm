package zero.to.mastery.data_structures.trees;

/**
 * Demonstrates binary search tree concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class BinarySearchTree {

    private BinaryNode node;

    /**
     * Creates a new {@code BinarySearchTree} instance for binary search tree operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public BinarySearchTree() {
        node = null;
    }

    /**
     * Executes is valid bst logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param root input value used by the is valid bst process
     * @param left input value used by the is valid bst process
     * @param right input value used by the is valid bst process
     * @return computed boolean result produced by the is valid bst process
     */
    private static boolean isValidBST(BinaryNode root, BinaryNode left, BinaryNode right) {
        if (root == null) return true;

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (left != null && root.getValue() <= left.getValue()) {
            return false;
        }

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (right != null && root.getValue() >= right.getValue()) {
            return false;
        }

        // check recursively for every node, is left true? and right also true?.
        return isValidBST(root.getLeft(), left, root) && isValidBST(root.getRight(), root, right);
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
        BinaryNode newNode = new BinaryNode(value);
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
     * @return computed binary node result produced by the lookup process
     */
    public BinaryNode lookup(int value) {
        if (this.node == null) {
            return null;
        }
        var currentNode = this.node;
        while (currentNode != null) {
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else if (value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else if (value == currentNode.getValue()) {
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

        BinaryNode nodeToRemove = node;
        BinaryNode parentNode = null;
        while (nodeToRemove.getValue() != value) { //Searching for the node to remove and it's parent
            parentNode = nodeToRemove;
            if (value < nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getLeft();
            } else if (value > nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getRight();
            }
        }

        BinaryNode replacementNode = null;
        if (nodeToRemove.getRight() != null) { //We have a right node
            replacementNode = nodeToRemove.getRight();
            if(replacementNode.getLeft() == null) { //We don't have a left node
                replacementNode.setLeft(nodeToRemove.getLeft());
            } else { //We have a have a left node, lets find the leftmost
                BinaryNode replacementParentNode = nodeToRemove;
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
    private void printTree(BinaryNode node) {
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
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(9);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(20);
        binarySearchTree.insert(170);
        binarySearchTree.insert(15);
        binarySearchTree.insert(1);
        binarySearchTree.remove(170);
        binarySearchTree.printTree();
        System.out.println("lookup node " + binarySearchTree.lookup(20).getValue());
        System.out.println("IS BST VALID ? " + isValidBST(binarySearchTree.node, null, null));
    }
}
