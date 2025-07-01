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
    TreeNode prev=null;
    public void flattenRec(TreeNode root) {
        if(root==null) return;

        flattenRec(root.right);
        flattenRec(root.left);

        root.right=prev;
        root.left=null;
        prev=root;
    }

    public void flattenStack(TreeNode root){
        if(root==null) return;
        Deque<TreeNode> stack=new ArrayDeque<>();

        stack.addFirst(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.removeFirst();
            
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
            if(!stack.isEmpty()) node.right=stack.peek();
            node.left=null;
        }
    }
    
    public void flatten(TreeNode root){
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode prev=cur.left;
                while(prev.right!=null) prev=prev.right;
                prev.right=cur.right;
                cur.right=cur.left;
            }
            cur.left=null;
            cur=cur.right;
        }
    }
}