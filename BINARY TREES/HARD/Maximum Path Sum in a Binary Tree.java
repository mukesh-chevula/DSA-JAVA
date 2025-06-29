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
class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        sum(root);
        return max;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        int leftVal = Math.max(0, sum(root.left));
        int rightVal = Math.max(0, sum(root.right));
        max = Math.max(max, root.val + leftVal + rightVal);
        return Math.max(leftVal, rightVal) + root.val;
    }
}