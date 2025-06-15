// User function Template for Java

class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
        Node cur=head;
        
        while(cur!=null && cur.next!=null){
            while(cur.next!=null && cur.data==cur.next.data){
                cur.next=cur.next.next;
                if (cur.next != null) {
                    cur.next.prev = cur; 
                }
            }
            cur=cur.next;
        }
        return head;
    }
}
