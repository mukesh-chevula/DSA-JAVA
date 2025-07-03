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

class BSTIterator {
    private Deque<TreeNode> stack = new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = stack.removeFirst();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty(); 
    }
    
    public void pushAll(TreeNode root) {
        for(; root != null; stack.addFirst(root), root = root.left); 
    }
}
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        BSTIterator i1=new BSTIterator(root1);
        BSTIterator i2=new BSTIterator(root2);
        List<Integer> res=new ArrayList<>();
        Integer v1 = i1.hasNext() ? i1.next() : null;
        Integer v2 = i2.hasNext() ? i2.next() : null;

        while (v1 != null || v2 != null) {
            if (v2 == null || (v1 != null && v1 <= v2)) {
                res.add(v1);
                v1 = i1.hasNext() ? i1.next() : null;
            } else {
                res.add(v2);
                v2 = i2.hasNext() ? i2.next() : null;
            }
        }
        return res;
    }
}