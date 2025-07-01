class Solution {
    // Function to convert binary tree to doubly linked list and return it.
    Node prev = null;
    Node head = null;
    
    Node bToDLL(Node root) {
        
        inOrderTraversal(root);
        
        return head;
    }
    
    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        
        inOrderTraversal(root.left);
        
        if (prev != null) {
            prev.right = root;
            root.left = prev;
        }
        
        if (head == null) {
            head = root;
        }
        
        prev = root;
        
        inOrderTraversal(root.right);
    }
}
