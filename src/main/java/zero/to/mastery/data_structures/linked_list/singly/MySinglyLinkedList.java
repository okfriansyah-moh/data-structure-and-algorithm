package zero.to.mastery.data_structures.linked_list.singly;

/**
 * Demonstrates my singly linked list concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class MySinglyLinkedList {
    private MySinglyLinkedNode head;
    private MySinglyLinkedNode tail;
    private int length;

    /**
     * Creates a new {@code MySinglyLinkedList} instance for my singly linked list operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param value input value used by the my singly linked list process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public MySinglyLinkedList(int value) {
        head = new MySinglyLinkedNode(value);
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
        head = new MySinglyLinkedNode(value, head);
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
        MySinglyLinkedNode newNode = new MySinglyLinkedNode(value);
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
        if(head == null) {
            return;
        }
        MySinglyLinkedNode currentNode = head;
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

        MySinglyLinkedNode leader = traverseToIndex(index - 1);
        MySinglyLinkedNode nextNode = leader.getNext();

        MySinglyLinkedNode newNode = new MySinglyLinkedNode(value, nextNode);
        leader.setNext(newNode);
        length++;
    }

    // insert method cara 2
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
            MySinglyLinkedNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            MySinglyLinkedNode newNode = new MySinglyLinkedNode(value);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
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

        MySinglyLinkedNode leader = traverseToIndex(index - 1);
        MySinglyLinkedNode nodeToRemove = leader.getNext();
        leader.setNext(nodeToRemove.getNext());
        length--;
    }

    //remove cara ke 2
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
            length--;
        } else {
            MySinglyLinkedNode current = head;
            int i;
            for (i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            length--;
            if (i == length - 1) {
                tail = current;
            }
        }
    }

    /**
     * Executes reverse logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void reverse() {
        MySinglyLinkedNode first = head;
        tail = head;
        MySinglyLinkedNode second = first.getNext();
        for (int i = 0; i < length - 1; i++) {
            MySinglyLinkedNode temp = second.getNext();
            second.setNext(first);
            first = second;
            second = temp;
        }
        head.setNext(null);
        head = first;
    }

    // reverse cara ke 2
    /**
     * Executes reverse2 logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param mySinglyLinkedList input value used by the reverse2 process
     * @return computed my singly linked list result produced by the reverse2 process
     */
    public MySinglyLinkedList reverse2(MySinglyLinkedList mySinglyLinkedList) {
        MySinglyLinkedList newList = new MySinglyLinkedList(mySinglyLinkedList.head.getValue());
        MySinglyLinkedNode current = mySinglyLinkedList.head;
        while (current.getNext() != null) {
            current = current.getNext();
            MySinglyLinkedNode newNode = new MySinglyLinkedNode(current.getValue());
            newNode.setNext(newList.head);
            newList.head = newNode;
            newList.length++;
        }
        return newList;
    }

    /**
     * Executes traverse to index logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param index input value used by the traverse to index process
     * @return computed my singly linked node result produced by the traverse to index process
     */
    public MySinglyLinkedNode traverseToIndex(int index) {
        index = wrapIndex(index);
        MySinglyLinkedNode currentNode = head;
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
     * @return computed my singly linked node result produced by the get head process
     */
    public MySinglyLinkedNode getHead() {
        return head;
    }

    /**
     * Executes get tail logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @return computed my singly linked node result produced by the get tail process
     */
    public MySinglyLinkedNode getTail() {
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
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(5);
        mySinglyLinkedList.append(8);
        mySinglyLinkedList.append(4);
        mySinglyLinkedList.prepend(10);
        mySinglyLinkedList.printList();
        mySinglyLinkedList.insert(2,15);
        mySinglyLinkedList.printList();
        mySinglyLinkedList.remove(2);
        mySinglyLinkedList.printList();
        mySinglyLinkedList.reverse();
        mySinglyLinkedList.printList();
    }
}

