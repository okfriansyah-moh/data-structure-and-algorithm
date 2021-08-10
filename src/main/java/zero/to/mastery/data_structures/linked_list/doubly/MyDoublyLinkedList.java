package zero.to.mastery.data_structures.linked_list.doubly;

public class MyDoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public MyDoublyLinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void prepend(int value) {
        Node newNode = new Node(value, null, head);
        head.setPrevious(newNode);
        head = newNode;
        length ++;
    }

    public void append(int value) {
        Node newNode = new Node(value, tail, null);
        tail.setNext(newNode);
        tail = newNode;
        length ++;
    }

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

    public Node traverseToIndex(int index) {
        index = wrapIndex(index);
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private int wrapIndex(int index) { //Used for wrapping the given index to make sure it's valid
        return Math.max(Math.min(index, length - 1), 0);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

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
