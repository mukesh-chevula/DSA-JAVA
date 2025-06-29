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
            int temp=-1;
            
            for (int i = 0; i < level; i++) {
                Node node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                if(temp==-1) temp=node.data;
            }
            
            res.add(temp);
        }
        return res;
    }
}