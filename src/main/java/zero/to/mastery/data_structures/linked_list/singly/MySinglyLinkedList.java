package zero.to.mastery.data_structures.linked_list.singly;

/**
 * A singly linked list implementation - a fundamental data structure where each node
 * contains a value and a reference to the next node. Unlike arrays, linked lists support
 * O(1) insertion/deletion at the head, but require O(n) to access by index.
 *
 * <p><b>Structure:</b></p>
 * <pre>
 * head → [5|next] → [8|next] → [4|next] → [null]
 *                                              ↑
 *                                            tail
 * 
 * Each node has two parts:
 *   - Value: the actual data (5, 8, 4, etc.)
 *   - Next: pointer to the next node
 * </pre>
 *
 * <p><b>Time Complexities:</b></p>
 * <ul>
 *   <li>Access by index: O(n) - must traverse from head</li>
 *   <li>Insert at head: O(1) - just update head pointer</li>
 *   <li>Insert at tail: O(1) - we maintain tail pointer</li>
 *   <li>Delete from head: O(1) - update head pointer</li>
 *   <li>Delete from middle: O(n) - must find previous node</li>
 *   <li>Reverse: O(n) - must visit every node</li>
 * </ul>
 *
 * <p><b>Space Complexity:</b> O(n) where n is number of nodes.</p>
 *
 * <p><b>Example Usage:</b></p>
 * <pre>
 * MySinglyLinkedList list = new MySinglyLinkedList(5);
 * list.append(8);      // List: 5 → 8
 * list.append(4);      // List: 5 → 8 → 4
 * list.prepend(10);    // List: 10 → 5 → 8 → 4
 * list.insert(1, 20);  // List: 10 → 20 → 5 → 8 → 4 (insert 20 at index 1)
 * list.printList();    // Output: 10-->20-->5-->8-->4
 * </pre>
 */
public class MySinglyLinkedList {
    private MySinglyLinkedNode head;    // Points to the first node
    private MySinglyLinkedNode tail;    // Points to the last node (for O(1) append)
    private int length;                 // Current number of nodes

    /**
     * Creates a new singly linked list with a single node containing the given value.
     * This initializes head and tail to point to this first node.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Create a new node with the given value</li>
     *   <li>Set head to this node (it's the first node)</li>
     *   <li>Set tail to this node (it's also the last node)</li>
     *   <li>Set length to 1</li>
     * </ol>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * MySinglyLinkedList list = new MySinglyLinkedList(5);
     * // Result: 5 (head=tail, both point to same node)
     * // length = 1
     * </pre>
     *
     * @param value the value to store in the first node
     */
    public MySinglyLinkedList(int value) {
        head = new MySinglyLinkedNode(value);
        tail = head;  // Initially, head and tail point to the same node
        length = 1;
    }

    /**
     * Adds a node to the beginning (head) of the list.
     * Time Complexity: O(1) - only updates pointers, no traversal needed.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Create a new node with the given value</li>
     *   <li>Set the new node's next to point to current head</li>
     *   <li>Update head to be the new node</li>
     *   <li>Increment length</li>
     * </ol>
     *
     * <p><b>Example: prepend(10) on list [5, 8]</b></p>
     * <pre>
     * Before: 5 → 8 → null
     * After:  10 → 5 → 8 → null
     *
     * Steps:
     * 1. Create node with value 10
     * 2. Set new node's next = head (which points to 5)
     * 3. Update head to point to new node
     * </pre>
     *
     * @param value the value to add at the head of the list
     */
    public void prepend(int value) {
        head = new MySinglyLinkedNode(value, head);  // Create new node pointing to old head
        length++;
    }

    /**
     * Adds a node to the end (tail) of the list.
     * Time Complexity: O(1) - we maintain a tail pointer, so no traversal needed.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Create a new node with the given value</li>
     *   <li>Set current tail's next to point to the new node</li>
     *   <li>Update tail to be the new node</li>
     *   <li>Increment length</li>
     * </ol>
     *
     * <p><b>Example: append(4) on list [5, 8]</b></p>
     * <pre>
     * Before: 5 → 8 → null (tail points to 8)
     * After:  5 → 8 → 4 → null (tail now points to 4)
     *
     * Steps:
     * 1. Create node with value 4
     * 2. Set tail.next = new node (8 now points to 4)
     * 3. Update tail to point to new node
     * </pre>
     *
     * @param value the value to add at the tail of the list
     */
    public void append(int value) {
        MySinglyLinkedNode newNode = new MySinglyLinkedNode(value);
        tail.setNext(newNode);  // Link current tail to new node
        tail = newNode;         // Update tail to new node
        length++;
    }

    /**
     * Prints all values in the linked list in a readable format.
     * Time Complexity: O(n) - must visit every node.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>If list is empty (head is null), return</li>
     *   <li>Print the value of the first node</li>
     *   <li>Move to the next node</li>
     *   <li>For each subsequent node, print "-->" followed by its value</li>
     *   <li>Continue until reaching the null at the end</li>
     * </ol>
     *
     * <p><b>Example: printList() on [10, 5, 8, 4]</b></p>
     * <pre>
     * Output: 10-->5-->8-->4
     * 
     * Process:
     * 1. Print 10 (first node)
     * 2. Move to next node (5)
     * 3. Print "-->5"
     * 4. Move to next node (8)
     * 5. Print "-->8"
     * 6. Move to next node (4)
     * 7. Print "-->4"
     * 8. Move to next node (null)
     * 9. Loop ends, print newline
     * </pre>
     */
    public void printList() {
        if(head == null) {
            return;  // Empty list
        }
        MySinglyLinkedNode currentNode = head;
        System.out.print(currentNode.getValue());  // Print first node
        currentNode = currentNode.getNext();
        // Print remaining nodes with arrow separator
        while (currentNode != null) {
            System.out.print("-->" + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    /**
     * Inserts a value at a specific index in the list.
     * Time Complexity: O(n) - must traverse to the target index.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Validate and wrap the index to ensure it's within bounds</li>
     *   <li>If index is 0, prepend the value</li>
     *   <li>If index is at length-1, append the value</li>
     *   <li>Otherwise, traverse to index-1, then insert new node between index-1 and index</li>
     * </ol>
     *
     * <p><b>Example: insert(1, 20) on list [10, 5, 8, 4] (length=4)</b></p>
     * <pre>
     * Before: 10 → 5 → 8 → 4 → null (indices: 0, 1, 2, 3)
     * After:  10 → 20 → 5 → 8 → 4 → null (20 inserted at index 1)
     * 
     * Process:
     * 1. Traverse to index 0 (node 10)
     * 2. Create new node with value 20
     * 3. Set new node's next = 10.next (which is 5)
     * 4. Set 10.next = new node
     * </pre>
     *
     * @param index the position where the value should be inserted (0-based)
     * @param value the value to insert
     */
    public void insert(int index, int value) {
        index = wrapIndex(index);  // Ensure index is within valid range
        if (index == 0) {
            prepend(value);
            return;
        }

        if (index == length - 1) {
            append(value);
            return;
        }

        // Find the node before the insertion point
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
     * <p>Summary: documents the key steps used by this practice implementation.</p>
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
     * Removes the node at a specific index from the list.
     * Time Complexity: O(n) - must traverse to the target index.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Validate and wrap the index</li>
     *   <li>If removing from head (index 0), update head pointer</li>
     *   <li>Otherwise, find the node before the one to remove</li>
     *   <li>Bypass the removed node by updating pointers</li>
     *   <li>Decrement length</li>
     * </ol>
     *
     * <p><b>Example: remove(1) on list [10, 5, 8, 4]</b></p>
     * <pre>
     * Before: 10 → 5 → 8 → 4 → null (removing 5 at index 1)
     * After:  10 → 8 → 4 → null (5 is removed)
     * 
     * Process:
     * 1. Find node at index 0 (10)
     * 2. Get the node 10 points to (5)
     * 3. Set 10.next = 5.next (which is 8)
     * </pre>
     *
     * @param index the position of the element to remove (0-based)
     */
    public void remove(int index) {
        index = wrapIndex(index);
        if(index == 0) {
            head = head.getNext();  // Just move head pointer to next node
            return;
        }

        // Find the node before the one to remove
        MySinglyLinkedNode leader = traverseToIndex(index - 1);
        MySinglyLinkedNode nodeToRemove = leader.getNext();
        leader.setNext(nodeToRemove.getNext());  // Bypass the removed node
        length--;
    }

    //remove cara ke 2
    /**
     * Executes remove2 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
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
     * Reverses the order of nodes in the list in-place.
     * Time Complexity: O(n) - must visit every node once.
     * Space Complexity: O(1) - only uses a few pointers, no extra structures.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Initialize three pointers: first (head), second (first.next), temp</li>
     *   <li>For each node, save the next pointer in temp</li>
     *   <li>Reverse the pointer by making current node point to previous</li>
     *   <li>Move all pointers forward one step</li>
     *   <li>After loop, set old head's next to null and update head</li>
     * </ol>
     *
     * <p><b>Detailed Example: reverse() on [1, 2, 3]</b></p>
     * <pre>
     * Initial: 1 → 2 → 3 → null
     *          ↑  ↑
     *       first second
     *
     * Iteration 1:
     * temp = 3's node
     * 2.next = 1 (reverse the pointer)
     * first = 2, second = 3
     * Result: 1 ← 2    3 → null
     *
     * Iteration 2:
     * temp = null
     * 3.next = 2 (reverse the pointer)
     * first = 3, second = null
     * Result: 1 ← 2 ← 3
     *
     * After loop:
     * 1.next = null
     * head = 3
     *
     * Final: 3 → 2 → 1 → null (reversed!)
     * </pre>
     */
    public void reverse() {
        MySinglyLinkedNode first = head;
        tail = head;  // Old head becomes new tail
        MySinglyLinkedNode second = first.getNext();
        
        // Process all nodes except the last
        for (int i = 0; i < length - 1; i++) {
            MySinglyLinkedNode temp = second.getNext();  // Save next pointer
            second.setNext(first);  // Reverse: point to previous node
            first = second;         // Move forward
            second = temp;          // Move forward
        }
        
        // Terminate the list at the new end
        head.setNext(null);
        head = first;  // Update head to new beginning
    }

    // reverse cara ke 2
    /**
     * Executes reverse2 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
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
     * Traverses the list to find the node at a specific index.
     * Time Complexity: O(n) - must walk through each node.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Start at the head node</li>
     *   <li>Loop 'index' times, moving to the next node each time</li>
     *   <li>Return the node at that position</li>
     * </ol>
     *
     * <p><b>Example: traverseToIndex(2) on [10, 5, 8, 4]</b></p>
     * <pre>
     * Start at head (10)
     * Iteration 1: Move to 5
     * Iteration 2: Move to 8
     * Return: Node with value 8
     * </pre>
     *
     * @param index the position to traverse to (0-based)
     * @return the node at the specified index
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
     * <p>Summary: documents the key steps used by this practice implementation.</p>
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
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @return computed my singly linked node result produced by the get head process
     */
    public MySinglyLinkedNode getHead() {
        return head;
    }

    /**
     * Executes get tail logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @return computed my singly linked node result produced by the get tail process
     */
    public MySinglyLinkedNode getTail() {
        return tail;
    }

    /**
     * Executes get length logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @return computed int result produced by the get length process
     */
    public int getLength() {
        return length;
    }

    /**
     * Demonstrates all core linked list operations in sequence.
     *
     * <p><b>Expected Output:</b></p>
     * <pre>
     * 10-->5-->8-->4        (after append and prepend)
     * 10-->15-->5-->8-->4   (after insert at index 1)
     * 10-->15-->8-->4       (after remove at index 2)
     * 4-->8-->15-->10       (after reverse)
     * </pre>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(5);
        mySinglyLinkedList.append(8);       // List: 5 → 8
        mySinglyLinkedList.append(4);       // List: 5 → 8 → 4
        mySinglyLinkedList.prepend(10);     // List: 10 → 5 → 8 → 4
        mySinglyLinkedList.printList();     // Output: 10-->5-->8-->4
        
        mySinglyLinkedList.insert(2, 15);   // Insert 15 at index 2
        mySinglyLinkedList.printList();     // Output: 10-->15-->5-->8-->4
        
        mySinglyLinkedList.remove(2);       // Remove element at index 2
        mySinglyLinkedList.printList();     // Output: 10-->15-->8-->4
        
        mySinglyLinkedList.reverse();       // Reverse the entire list
        mySinglyLinkedList.printList();     // Output: 4-->8-->15-->10
    }
}

