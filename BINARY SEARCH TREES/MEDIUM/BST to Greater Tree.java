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
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        revin(root);
        return root;
    }
    public void revin(TreeNode root){
        if(root==null) return;
        revin(root.right);
        sum+=root.val;
        root.val=sum;
        revin(root.left);
    }
}