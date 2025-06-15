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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode cur=head;
        int l=1;
        while(cur.next!=null){
            cur=cur.next;
            l++;
        }
        k=k%l;
        if(k==l)
            return head;
        cur.next=head;
        int i=1;
        cur=head;
        while(i<(l-k)){
            cur=cur.next;
            i++;
        }

        head=cur.next;
        cur.next=null;
        return head;
    }
}
