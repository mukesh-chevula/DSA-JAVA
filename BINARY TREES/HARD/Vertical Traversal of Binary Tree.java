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
    private static class Tuple{
        TreeNode node;
        int x,y;
        Tuple(TreeNode node,int x,int y){
            this.node=node;
            this.x=x;
            this.y=y;
        }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new ArrayDeque<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tup=q.poll();
            TreeNode node=tup.node;
            int x=tup.x;
            int y=tup.y;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if(node.left!=null){
                q.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,x+1,y+1));
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys :map.values()){
            List<Integer> col = new ArrayList<>();
            for(PriorityQueue<Integer> nodes:ys.values()){
                while(!nodes.isEmpty()){
                    col.add(nodes.poll());
                }
            }
            res.add(col);
        }
        return res;
    }
}