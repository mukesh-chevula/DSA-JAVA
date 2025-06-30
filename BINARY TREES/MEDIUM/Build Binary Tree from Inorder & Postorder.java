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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) map.put(inorder[i],i);

        return _buildTree(inorder,0,n-1,postorder,n-1,0,map);
    }
    private TreeNode _buildTree(int[] inorder, int iS, int iE,
                                int[] postorder, int pS, int pE,
                                Map<Integer, Integer> map) {
        if (pS < pE || iS > iE) return null;

        TreeNode root = new TreeNode(postorder[pS]);
        int iRoot = map.get(root.val);
        int rightSize = iE - iRoot;

        root.right = _buildTree(inorder, iRoot + 1, iE,
                                postorder, pS - 1, pS - rightSize, map);

        root.left = _buildTree(inorder, iS, iRoot - 1,
                               postorder, pS - rightSize - 1, pE, map);

        return root;
    }
}