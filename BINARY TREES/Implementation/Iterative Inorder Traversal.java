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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        TreeNode node = root;
        while (true) {
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                if(stack.empty()) break;
                node=stack.pop();
                res.add(node.val);
                node=node.right;
            }
        }
        
        return res;
    }
}