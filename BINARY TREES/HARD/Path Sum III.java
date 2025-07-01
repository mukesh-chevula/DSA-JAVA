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
    public void helper(TreeNode root,long curSum,int target,HashMap<Long, Integer> map){
        if(root==null) return;
        curSum+=root.val;
        if(map.containsKey(curSum-target)) count+=map.get(curSum - target);

        if(!map.containsKey(curSum)) map.put(curSum,1);
        else map.put(curSum, map.get(curSum)+1);

        helper(root.left,curSum,target,map);
        helper(root.right,curSum,target,map);
        map.put(curSum,map.get(curSum)-1);
    }
    int count =0;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Long, Integer> map = new HashMap();
        map.put(0L,1);
        helper(root, 0, sum, map);
        return count;
    }
}