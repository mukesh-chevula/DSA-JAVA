// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    class NodeInfo {
        boolean isBST;
        int size;
        int min;
        int max;

        NodeInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    int maxBSTSize = 0;

    public int largestBst(Node root) {
        postOrder(root);
        return maxBSTSize;
    }

    private NodeInfo postOrder(Node node) {
        if (node == null) return new NodeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        NodeInfo left = postOrder(node.left);
        NodeInfo right = postOrder(node.right);

        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
            int size = 1 + left.size + right.size;
            maxBSTSize = Math.max(maxBSTSize, size);
            return new NodeInfo(true, size, Math.min(node.data, left.min), Math.max(node.data, right.max));
        }

        return new NodeInfo(false, 0, 0, 0);
    }
}
