package zero.to.mastery.data_structures.linked_list.hackerrank_case;

/**
 * Demonstrates reverse linked list2 concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
public class ReverseLinkedList2 {
    /*
        Given a Linked List and numbers m and n , return it back with only positions
        m to n in reverse.
        ex :
        1 -> 2 -> 3 -> 4 -> 5 -> null
        m = 2 ; n = 4
        Constraints :
        will m and n always be within the bounds of the linked list?
        Yes, assume 1 <= m <= n <= length of linked list.
        Can we receive m and n values for the whole linked list?
        Yes, we can receive m = 1 and n = length of linked list.
        Steps to reverse :
        1. Get current node
        2. Store next value
        3. Update next value to list so far
        4. Store current Node on list so far
        5. Update current node to stored next value at  steps 2
     */
    /**
     * Executes reverse between logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param head input value used by the reverse between process
     * @param left input value used by the reverse between process
     * @param right input value used by the reverse between process
     * @return computed list node result produced by the reverse between process
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int currentPos = 1;
        var currentNode = head;
        var start = head;
        while (currentPos < left) {
            start = currentNode;
            currentNode = currentNode.next;
            currentPos++;
        }
        ListNode newList = null;
        var tail = currentNode;
        while (currentPos >= left && currentPos <= right) {
            var next = currentNode.next;
            currentNode.next = newList;
            newList = currentNode;
            currentNode = next;
            currentPos++;
        }
        start.next = newList;
        tail.next = currentNode;
        if (left > 1) {
            return head;
        } else {
            return newList;
        }
    }
}

/**
 * Demonstrates list node concepts for data-structure and algorithm practice.
 *
 * <p>Use this class to study the implementation flow, expected behavior, and practical output.</p>
 */
class ListNode {
    int val;
    ListNode next;
    /**
     * Creates an empty node with default field values.
     *
     * <p>Output: node instance where {@code val} uses default integer value and
     * {@code next} is {@code null}.</p>
     */
    ListNode() {}
    /**
     * Creates a node with a value and no next link.
     *
     * @param val integer payload to store in the node
     * Output: node instance initialized with {@code val} and {@code next = null}.
     */
    ListNode(int val) { this.val = val; }
    /**
     * Creates a node with both value and next-node reference.
     *
     * @param val integer payload to store in the node
     * @param next link to the subsequent node
     * Output: fully initialized node for linked-list chaining.
     */
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
