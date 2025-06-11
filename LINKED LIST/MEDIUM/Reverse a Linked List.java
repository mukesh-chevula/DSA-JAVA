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
    //Recursion
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    //Iterative Method
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next_node = null;

        while(cur!=null){
            next_node = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next_node;
        }

        return prev;
    }
}