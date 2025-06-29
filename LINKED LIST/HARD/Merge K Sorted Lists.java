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
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)-> a.val-b.val);

        for(ListNode i:lists){
            if(i!=null) pq.offer(i);
        }
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            cur.next=node;
            cur=cur.next;
            if(node.next!=null){
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
