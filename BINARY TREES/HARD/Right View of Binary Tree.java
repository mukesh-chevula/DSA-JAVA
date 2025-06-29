/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/

class Solution {
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        // add code here.
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
                if(i==level-1) res.add(node.data);
            }
        }
        return res;
    }
}

class Recursive{
    public List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsRight(root, 0, res);
        return res;
    }

    private void dfsRight(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;
        if (depth == res.size()) res.add(node.val);
        dfsRight(node.right, depth + 1, res);
        dfsRight(node.left, depth + 1, res);
    }
}