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
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        TreeNode startNode=null;
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        parent.put(root,null);
        q.offer(root);
        int count =1;
        while (!q.isEmpty()) {
            int level = q.size();
            
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                if(node.val==start){
                    startNode=node;
                }
                if (node.left != null) {
                    q.offer(node.left);
                    parent.put(node.left,node);
                }
                if (node.right != null) {
                    q.offer(node.right);
                    parent.put(node.right,node);
                }
                count++;
            }
        }

        q=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();

        q.offer(startNode);
        visited.add(startNode);
        int curTime=-1;


        while(!q.isEmpty()){
            int size=q.size();
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
            curTime++;
            if(visited.size()==count) break;
        }

        return curTime;
    }
}