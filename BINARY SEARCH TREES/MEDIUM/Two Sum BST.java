/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BSTIterator {
    private Deque<TreeNode> stack = new ArrayDeque<>();
    private boolean forward; // true for next(), false for before()

    public BSTIterator(TreeNode root, boolean forward) {
        this.forward = forward;
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        if (forward) {
            pushAll(node.right); 
        } else {
            pushAll(node.left);
        }
        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = forward ? node.left : node.right;
        }
    }
}


class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator leftIt = new BSTIterator(root, true);
        BSTIterator rightIt = new BSTIterator(root, false);

        int left = leftIt.next();
        int right = rightIt.next();

        while (left < right) {
            int sum = left + right;
            if (sum == k) return true;
            else if (sum < k) left = leftIt.next();
            else right = rightIt.next();
        }

        return false;
    }
}