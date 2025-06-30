/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        parent.put(root,null);
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                    parent.put(node.left,node);
                }
                if (node.right != null) {
                    q.offer(node.right);
                    parent.put(node.right,node);
                }
            }
        }

        q=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();

        q.offer(target);
        visited.add(target);
        int curDist=0;

        while(!q.isEmpty()){
            int size=q.size();
            if(curDist==k) break;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                if(node.left!=null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }
                if(parent.get(node)!=null && !visited.contains(parent.get(node))){
                    q.offer(parent.get(node));
                    visited.add(parent.get(node));
                }
            }
            curDist++;
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
}