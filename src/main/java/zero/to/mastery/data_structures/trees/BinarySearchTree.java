package zero.to.mastery.data_structures.trees;

public class BinarySearchTree {

    private BinaryNode node;

    public BinarySearchTree() {
        node = null;
    }

    // insert process in video
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
    public void printTree() {
        count = 0;
        printTree(node);
    }

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
    }
}
