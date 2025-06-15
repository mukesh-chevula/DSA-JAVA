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
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        ListNode next_node=null;
        while(cur!=null){
            next_node=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next_node;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head,int k){
        ListNode cur=head;
        ListNode start=head;
        ListNode end=head;
        int c=0;
        ListNode prevTail=null;
        ListNode newHead=null;
        while(cur!=null){
            if(c==0){
                start=cur;
            }
            c++;
            if(c==k){
                end=cur;
                ListNode nextGroup=end.next;
                end.next=null;
                ListNode revHead=reverse(start);
                if(newHead==null)newHead=revHead;
                if(prevTail!=null)prevTail.next=revHead;
                prevTail=start;
                cur=nextGroup;
                c=0;
            }else{
                cur=cur.next;
            }
        }
        if(c>0&&prevTail!=null){
            prevTail.next=start;
        }
        return newHead==null?head:newHead;
    }
}
