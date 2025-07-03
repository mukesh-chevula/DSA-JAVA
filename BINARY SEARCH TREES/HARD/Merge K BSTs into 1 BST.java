class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> leaves = new HashSet<>();
        
        for (TreeNode t : trees) {
            map.put(t.val, t);
            if (t.left != null) leaves.add(t.left.val);
            if (t.right != null) leaves.add(t.right.val);
        }
        
        TreeNode root = null;
        for (TreeNode t : trees) {
            if (!leaves.contains(t.val)) {
                if (root != null) return null;
                root = t;
            }
        }
        
        if (root == null) return null;
        
        if (!merge(root, map)) return null;
        
        if (map.size() != 1 || !isValidBST(root)) return null;
        
        return root;
    }
    
    private boolean merge(TreeNode t, HashMap<Integer, TreeNode> map) {
        if (t.left != null && map.containsKey(t.left.val)) {
            t.left = map.remove(t.left.val);
            if (!merge(t.left, map)) return false;
        }
        
        if (t.right != null && map.containsKey(t.right.val)) {
            t.right = map.remove(t.right.val);
            if (!merge(t.right, map)) return false;
        }
        
        return true;
    }
    
    private boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean validate(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}