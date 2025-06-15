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
    static{
        ListNode head=new ListNode(0);
        for(int i=0;i<300;i++) removeElements(head,0);
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;

        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next; 
            }
        }

        return dummy.next;
    }
}
