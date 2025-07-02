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
    public TreeNode bstFromPreorder(int[] arr) {
        return dfs(arr,Integer.MAX_VALUE,new int[1]);
    }
    public TreeNode dfs(int[] arr, int ub,int[] i){
        if(i[0]==arr.length || arr[i[0]]>ub) return null;

        TreeNode root=new TreeNode(arr[i[0]++]);
        root.left=dfs(arr,root.val,i);
        root.right=dfs(arr,ub,i);
        return root;
    }
}