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

    private int sum = 0;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        addSum(root, low, high);
        return sum;
    }

    private void addSum(TreeNode node, int low, int high) {
        if(node == null) {
            return;
        }


        if(low <= node.val && node.val <= high) {
            sum += node.val;
        }

        if(high < node.val) {
            addSum(node.left, low, high);
        
        } else if(low > node.val) {
            addSum(node.right, low, high);
        
        } else {
            addSum(node.left, low, high);
            addSum(node.right, low, high);
        }
    }
}