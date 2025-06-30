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
    static class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node,int index){
            this.index=index;
            this.node=node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        int res=Integer.MIN_VALUE;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int minSize=q.peek().index;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                int id=p.index-minSize;
                if(p.node.left!=null) q.offer(new Pair(p.node.left,2*id+1));
                if(p.node.right!=null) q.offer(new Pair(p.node.right,2*id+2));
                if(i==size-1) res=Math.max(p.index-minSize+1,res);
            }
        }
        return res;
    }
}