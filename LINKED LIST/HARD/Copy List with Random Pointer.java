/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public static Node copyRandomList(Node head) {
        Node cur=head;
        while(cur!=null){
            Node newnode=new Node(cur.val);
            newnode.next=cur.next;
            cur.next=newnode;
            cur=newnode.next;
        }

        cur=head;
        while(cur!=null){
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur=cur.next.next;
        }

        Node dummy = new Node(0);
        Node copyCur = dummy;
        cur=head;
        while(cur!=null){
            Node copy = cur.next;
            cur.next = copy.next;

            copyCur.next = copy;
            copyCur = copy;

            cur = cur.next;
        }
        return dummy.next;
    }
}
