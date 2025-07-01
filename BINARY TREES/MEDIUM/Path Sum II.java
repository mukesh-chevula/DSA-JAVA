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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root,res,path,sum);
        return res;
    }
    void helper(TreeNode root,List<List<Integer>> res,List<Integer> path,int sum){
        if(root==null) return;
        path.add(root.val);
        if(root.left==null &&root.right==null&&sum==root.val) res.add(new ArrayList<>(path));

        helper(root.left,res,path,sum-root.val);
        helper(root.right,res,path,sum-root.val);
        path.remove(path.size()-1);
    }
}