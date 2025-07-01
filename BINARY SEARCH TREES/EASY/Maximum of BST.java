/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    // Function to find the minimum element in the given BST.
    int maxValue(Node root) {
        // code here
        if(root==null) return 0;
        while(root.right!=null) root=root.right;
        return root.data;
    }
}