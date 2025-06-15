class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node dum = new Node();
        dum.data = 0;
        Node curr = dum;
        Node temp = head;
        while(temp != null)
        {
            if(temp.data != x)
            {
                curr.next = temp;
                temp.prev = curr;
                
                curr = curr.next;
            }
            temp = temp.next;
        }
        curr.next = null;
        
        return dum.next;
    }
}