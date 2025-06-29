/* A binary tree node class
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public static int h(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = h(root.left);
        int rightHeight = h(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(h(root.left) - h(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
}