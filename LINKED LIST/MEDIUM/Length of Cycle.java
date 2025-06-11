// class Node {
//     int data;        
//     Node next;      

//     Node(int data1, Node next1) {
//         data = data1;
//         next = next1;
//     }

//     Node(int data1) {
//         data = data1;
//         next = null;
//     }
// }

public class Solution {
    static int findLength(Node slow, Node fast){
        int cnt = 1;
        fast = fast.next;
        while(slow != fast){
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }

    static int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;  
            fast = fast.next.next; 
            if (slow == fast) {
                return findLength(slow, fast);
            }
        }
        return 0; 
    }
}
