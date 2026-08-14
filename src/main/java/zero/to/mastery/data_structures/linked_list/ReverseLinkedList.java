package zero.to.mastery.data_structures.linked_list;

/**
 * Demonstrates reverse linked list concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     * link = https://leetcode.com/problems/reverse-linked-list-ii/
     */
    public ListNodes reverseBetween(ListNodes head, int left, int right) {
        int currentPos = 1;
        var currentNode = head;
        var start = head;
        while (currentPos < left) {
            start = currentNode;
            currentNode = currentNode.next;
            currentPos++;
        }
        ListNodes newList = null;
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
 * Demonstrates list nodes concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
class ListNodes {
    int val;
    ListNodes next;
    /**
     * Creates an empty node with default field values.
     *
     * <p>Output: node instance where {@code val} uses default integer value and
     * {@code next} is {@code null}.</p>
     */
    ListNodes() {}
    /**
     * Creates a node with a value and no next link.
     *
     * @param val integer payload to store in the node
     * Output: node instance initialized with {@code val} and {@code next = null}.
     */
    ListNodes(int val) { this.val = val; }
    /**
     * Creates a node with both value and next-node reference.
     *
     * @param val integer payload to store in the node
     * @param next link to the subsequent node
     * Output: fully initialized node for linked-list chaining.
     */
    ListNodes(int val, ListNodes next) { this.val = val; this.next = next; }
}
