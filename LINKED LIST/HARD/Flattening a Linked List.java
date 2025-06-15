class Solution {
    // Function to flatten a linked list
    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data < b.data) {
            a.bottom = merge(a.bottom, b);
            return a;
        } else {
            b.bottom = merge(a, b.bottom);
            return b;
        }
    }

    Node flatten(Node root) {
        if (root == null || root.next == null) return root;

        root.next = flatten(root.next); 
        root = merge(root, root.next);  

        return root;
    }
}
