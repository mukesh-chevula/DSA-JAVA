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
    List<Integer> sort=new ArrayList<>();
    private void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            sort.add(root.val);
            inorder(root.right);
        }
    }

    public List<Integer> bs(int val){
        int low=0;
        int high=sort.size()-1;
        int min=-1;
        int max=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(sort.get(mid)==val){
                return Arrays.asList(val,val);
            }
            else if(sort.get(mid)<val){
                low=mid+1;
                if(min<sort.get(mid)){
                    min=sort.get(mid);
                }
                
            }
            else{
                high=mid-1;
                if(max>sort.get(mid)||max==-1){
                    max=sort.get(mid);
                }
            }
        }
        return Arrays.asList(min,max);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            int val = queries.get(i);
            result.add(bs(val));
        }
        return result;
    }

}