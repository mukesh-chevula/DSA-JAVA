/* Height of a Binary Tree */
class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class HeightOfBinaryTree {
    // Recursive approach to calculate the height of a binary tree
    public static int height(Node root) {
        if (root == null) {
            return -1; // Return -1 for an empty tree
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1; // Add 1 for the current level
    }

    // Iterative approach using Queue
    public int heightIterative(Node root) {
        int res = -1;
        Queue<Node> q = new LinkedList<>();
        if (root == null) return res;

        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();

            for (int i = 0; i < level; i++) {
                Node node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            res++;
        }
        return res;
    }
}
