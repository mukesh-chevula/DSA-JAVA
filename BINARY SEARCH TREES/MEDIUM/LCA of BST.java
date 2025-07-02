/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p||root==q) return root;
        int pval=p.val,qval=q.val,curval;
        TreeNode cur=root;
        while(cur!=null){
            curval=cur.val;
            if(curval>pval && curval>qval){
                cur=cur.left;
            }else if(curval<pval && curval<qval){
                cur=cur.right;
            }else if((curval==pval||curval==qval)||(curval>pval && curval<qval) || (curval<pval && curval>qval)){
                return cur;
            }
        }
        return cur;
    }
}