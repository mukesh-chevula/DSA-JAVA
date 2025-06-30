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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) map.put(inorder[i],i);

        return _buildTree(preorder,0,n-1,inorder,0,n-1,map);
    }
    TreeNode _buildTree(int[] preorder,int pS,int pE,int[] inorder,int iS,int iE,Map<Integer,Integer> map){
        if(pS>pE || iS>iE) return null;

        TreeNode root=new TreeNode(preorder[pS]);

        int iroot=map.get(root.val);
        int left=iroot-iS;

        root.left=_buildTree(preorder,pS+1,pS+left,inorder,iS,iroot-1,map);
        root.right=_buildTree(preorder,pS+left+1,pE,inorder,iroot+1,iE,map);

        return root;
    }
}