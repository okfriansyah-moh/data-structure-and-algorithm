package zero.to.mastery.data_structures.linked_list;

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

class ListNodes {
    int val;
    ListNodes next;
    ListNodes() {}
    ListNodes(int val) { this.val = val; }
    ListNodes(int val, ListNodes next) { this.val = val; this.next = next; }
}
