/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null) return res;
        
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            
            for (int i = 0; i < level; i++) {
                Node node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                if(i==0) res.add(node.data);
            }
        }
        return res;
    }
}

class Recursive{
    public List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsLeft(root, 0, res);
        return res;
    }

    private void dfsLeft(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;
        if (depth == res.size()) res.add(node.val);
        dfsLeft(node.left, depth + 1, res);
        dfsLeft(node.right, depth + 1, res);
    }

}