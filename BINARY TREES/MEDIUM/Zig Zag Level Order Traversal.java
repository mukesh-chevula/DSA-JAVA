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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return res;
        boolean k=false;
        
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                if(k) temp.addFirst(node.val);
                else temp.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(temp);
            k=!k;
        }
        return res;
    }
}