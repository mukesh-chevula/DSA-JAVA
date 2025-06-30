class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int lh=lH(root),rh=rH(root);

        if(lh==rh) return ((2<<lh)-1);

        return 1+countNodes(root.left)+countNodes(root.right);
    }
    int lH(TreeNode root){
        int c=0;
        while(root.left!=null){
            c++;
            root=root.left;
        }
        return c;
    }
    int rH(TreeNode root){
        int c=0;
        while(root.right!=null){
            c++;
            root=root.right;
        }
        return c;
    }
}