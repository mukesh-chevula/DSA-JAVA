/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null; right = null; }
 * }
 */

class Pair {
    TreeNode node;
    int val;
    
    Pair(TreeNode node, int val) {
        this.node = node;
        this.val = val;
    }
}

class Solution {
    List<List<Integer>> treeTraversal(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        if (root == null) {
            res.add(pre);
            res.add(in);
            res.add(post);
            return res;
        }
        
        stack.push(new Pair(root, 1));
        
        while (!stack.empty()) {
            Pair p = stack.pop();
            
            if (p.val == 1) {
                pre.add(p.node.data);
                
                stack.push(new Pair(p.node, 2));
                
                if (p.node.left != null) {
                    stack.push(new Pair(p.node.left, 1));
                }
            } else if (p.val == 2) {
                in.add(p.node.data);
                
                stack.push(new Pair(p.node, 3));
                
                if (p.node.right != null) {
                    stack.push(new Pair(p.node.right, 1));
                }
            } else if (p.val == 3) {
                post.add(p.node.data);
            }
        }
        
        res.add(pre);
        res.add(in);
        res.add(post);
        return res;
    }
}