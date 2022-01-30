package zero.to.mastery.data_structures.linked_list.hackerrank_case;

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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
