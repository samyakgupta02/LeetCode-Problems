/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverseList(slow.next);
        slow.next = null; // Cut off the first half

        ListNode firstHalfNode = head;
        ListNode secondHalfNode = secondHalfHead;
        while (secondHalfNode != null) {
            ListNode temp1 = firstHalfNode.next;
            ListNode temp2 = secondHalfNode.next;

            firstHalfNode.next = secondHalfNode;
            secondHalfNode.next = temp1;

            firstHalfNode = temp1;
            secondHalfNode = temp2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}