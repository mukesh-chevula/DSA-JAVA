class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            TreeNode parentX = null, parentY = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                
                if (node.left != null) {
                    q.offer(node.left);
                    if (node.left.val == x) {
                        parentX = node;
                    } else if (node.left.val == y) {
                        parentY = node;
                    }
                }

                if (node.right != null) {
                    q.offer(node.right);
                    if (node.right.val == x) {
                        parentX = node;
                    } else if (node.right.val == y) {
                        parentY = node;
                    }
                }
            }

            if (parentX != null && parentY != null) {
                return parentX != parentY;
            }
            if (parentX != null || parentY != null) {
                return false;
            }
        }
        return false;
    }
}
