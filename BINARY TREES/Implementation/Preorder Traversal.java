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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        return helper(root,res);
    }
    public List<Integer> helper(TreeNode root, List<Integer>res){
        if(root!=null){
            res.add(root.val);
            helper(root.left,res);
            helper(root.right,res);
        }
        return res;
    }
}