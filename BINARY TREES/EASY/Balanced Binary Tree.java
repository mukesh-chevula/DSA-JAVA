/* A binary tree node class
class Node
{
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
} */

class Solution {
    // Method to calculate the height of a binary tree
    public static int h(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = h(root.left);
        int rightHeight = h(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method to check if a binary tree is balanced
    public boolean isBalanced(Node root) {
        if (root == null) return true;
        if (Math.abs(h(root.left) - h(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    // Optimized method to check if a binary tree is balanced
    public boolean isBalancedOptmised(Node root) {
        return checkBalance(root) != -1;
    }

    // Helper method for optimized balance check
    private int checkBalance(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkBalance(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkBalance(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}