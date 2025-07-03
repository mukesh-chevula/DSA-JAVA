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

// class TreeNode
// {
//     int val;
//     TreeNode left, right;

//     public TreeNode(int d)
//     {
//         val = d;
//         left = right = null;
//     }
// }

class Solution {
    class NodeInfo {
        boolean isBST;
        int min;
        int max;
        int sum;

        NodeInfo(boolean isBST, int min, int max,int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum=sum;
        }
    }

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    private NodeInfo postOrder(TreeNode node) {
        if (node == null) return new NodeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);


        NodeInfo left = postOrder(node.left);
        NodeInfo right = postOrder(node.right);

        if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
            
            int curSum = node.val + left.sum + right.sum;

            if (curSum > 0) maxSum = Math.max(maxSum, curSum);

            return new NodeInfo(true,
                Math.min(node.val, left.min),
                Math.max(node.val, right.max),
                curSum
            );
        }

        return new NodeInfo(false, 0, 0, 0);
    }
}
