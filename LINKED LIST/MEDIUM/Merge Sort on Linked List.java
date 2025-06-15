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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }

        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMiddle);

        return merge(left, right);
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } 

        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode tail = new ListNode(0); 
        ListNode dummy = tail;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        tail.next = (left != null) ? left : right;

        return dummy.next;
    }
}
