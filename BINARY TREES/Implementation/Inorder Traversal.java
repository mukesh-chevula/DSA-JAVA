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
    public List<Integer> inorderTraversal(TreeNode root) {
        return helper(root,new ArrayList<>());
    }
    public List<Integer> helper(TreeNode root, List<Integer> res){
        if(root!=null){
            helper(root.left,res);
            res.add(root.val);
            helper(root.right,res);
        }
        return res;
    }

    public List<Integer> morrisInorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode curr = root;
        
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return res;
    }
}