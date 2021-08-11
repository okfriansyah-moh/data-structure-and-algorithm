package zero.to.mastery.data_structures.linked_list.singly;

public class MySinglyLinkedList {
    private MySinglyLinkedNode head;
    private MySinglyLinkedNode tail;
    private int length;

    public MySinglyLinkedList(int value) {
        head = new MySinglyLinkedNode(value);
        tail = head;
        length = 1;
    }

    public void prepend(int value) {
        head = new MySinglyLinkedNode(value, head);
        length ++;
    }

    public void append(int value) {
        MySinglyLinkedNode newNode = new MySinglyLinkedNode(value);
        tail.setNext(newNode);
        tail = newNode;
        length ++;
    }

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

    public MySinglyLinkedNode traverseToIndex(int index) {
        index = wrapIndex(index);
        MySinglyLinkedNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private int wrapIndex(int index) { //Used for wrapping the given index to make sure it's valid
        return Math.max(Math.min(index, length - 1), 0);
    }

    public MySinglyLinkedNode getHead() {
        return head;
    }

    public MySinglyLinkedNode getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

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

