class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverseList(slow);

        ListNode firstHalfNode = head;
        ListNode secondHalfNode = secondHalfHead;
        
        while (secondHalfNode != null) {
            if (firstHalfNode.val != secondHalfNode.val) {
                return false;
            }
            firstHalfNode = firstHalfNode.next;
            secondHalfNode = secondHalfNode.next;
        }

        return true;
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