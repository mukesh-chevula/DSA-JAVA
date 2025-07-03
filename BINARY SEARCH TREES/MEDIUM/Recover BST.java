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
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;

    public void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);

        if (prev == null)
            prev = root;
        else {
            if (prev.val > root.val) {
                if (first == null) {
                    first = prev;
                    middle = root;
                } else {
                    last = root;
                }
            }
        }
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = last = prev = middle = null;
        inorder(root);
        if (first != null && last != null)
            swap(first, last);
        else if (first != null && middle != null)
            swap(first, middle);
    }
}