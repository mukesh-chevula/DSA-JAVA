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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> al=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.right==null){
                al.add(curr.val);
                curr=curr.left;
            }else{
                TreeNode prev=curr.right;
                while(prev.left!=null && prev.left!=curr){
                    prev=prev.left;
                }
                if(prev.left==null){
                 prev.left=curr;
                 al.add(curr.val);
                 curr=curr.right;
                }else{
                 prev.left=null;
                 curr=curr.left;
                }
            }
        }
        Collections.reverse(al);
        return al;
    }
}