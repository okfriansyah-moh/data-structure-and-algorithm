package zero.to.mastery.data_structures.linked_list.doubly;

/**
 * Demonstrates my doubly linked list concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class MyDoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    /**
     * Creates a new {@code MyDoublyLinkedList} instance for my doubly linked list operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param value input value used by the my doubly linked list process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public MyDoublyLinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    /**
     * Executes prepend logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param value input value used by the prepend process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void prepend(int value) {
        Node newNode = new Node(value, null, head);
        head.setPrevious(newNode);
        head = newNode;
        length ++;
    }

    /**
     * Executes append logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param value input value used by the append process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void append(int value) {
        Node newNode = new Node(value, tail, null);
        tail.setNext(newNode);
        tail = newNode;
        length ++;
    }

    /**
     * Executes print list logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void printList() {
        Node currentNode = head;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null) {
            System.out.print("-->" + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    /**
     * Executes insert logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param index input value used by the insert process
     * @param value input value used by the insert process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void insert(int index, int value) {
        index = wrapIndex(index);
        if (index == 0) {
            prepend(value);
            return;
        }

        if (index == length - 1) {
            append(value);
            return;
        }

        Node leader = traverseToIndex(index - 1);
        Node follower = leader.getNext();

        Node newNode = new Node(value, leader, follower);
        leader.setNext(newNode);
        follower.setPrevious(newNode);
        length++;
    }

    // insert methode ke 2
    /**
     * Executes insert2 logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param index input value used by the insert2 process
     * @param value input value used by the insert2 process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void insert2(int index, int value) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node newNode = new Node(value);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            newNode.setPrevious(current);
            newNode.getNext().setPrevious(newNode);
            length++;
        }
    }

    /**
     * Executes remove logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param index input value used by the remove process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void remove(int index) {
        index = wrapIndex(index);
        if(index == 0) {
            head = head.getNext();
            return;
        }

        Node leader = traverseToIndex(index - 1);
        Node nodeToRemove = leader.getNext();
        leader.setNext(nodeToRemove.getNext());
        nodeToRemove.getNext().setPrevious(leader);
        length--;
    }

    // remove methode ke 2
    /**
     * Executes remove2 logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param index input value used by the remove2 process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void remove2(int index) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
            head = this.head.getNext();
            this.head.setPrevious(null);
            length--;
        } else {
            Node current = head;
            int i;
            for (i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            length--;
            if (i == length - 1) {
                tail = current;
            } else {
                current.getNext().setPrevious(current);
            }
        }
    }

    /**
     * Executes traverse to index logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param index input value used by the traverse to index process
     * @return computed node result produced by the traverse to index process
     */
    public Node traverseToIndex(int index) {
        index = wrapIndex(index);
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Executes wrap index logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param index input value used by the wrap index process
     * @return computed int result produced by the wrap index process
     */
    private int wrapIndex(int index) { //Used for wrapping the given index to make sure it's valid
        return Math.max(Math.min(index, length - 1), 0);
    }

    /**
     * Executes get head logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @return computed node result produced by the get head process
     */
    public Node getHead() {
        return head;
    }

    /**
     * Executes get tail logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @return computed node result produced by the get tail process
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Executes get length logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @return computed int result produced by the get length process
     */
    public int getLength() {
        return length;
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
        MyDoublyLinkedList mySinglyLinkedList = new MyDoublyLinkedList(5);
        mySinglyLinkedList.append(7);
        mySinglyLinkedList.append(4);
        mySinglyLinkedList.prepend(10);
        mySinglyLinkedList.printList();
        mySinglyLinkedList.insert(2,15);
        mySinglyLinkedList.printList();
        mySinglyLinkedList.remove(0);
        mySinglyLinkedList.printList();
    }
}
