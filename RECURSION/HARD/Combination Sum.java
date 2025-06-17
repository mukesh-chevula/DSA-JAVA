class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        helper(nums,0,target,0,res, new ArrayList<>());
        return res;
    }
    public void helper(int[] nums, int index, int target, int cursum, List<List<Integer>> res,List<Integer> ds){
        if(index>=nums.length){
            if(cursum==target) res.add(new ArrayList<>(ds));
            return;
        }
        if(cursum>target) return;

        ds.add(nums[index]);
        helper(nums,index,target,cursum+nums[index],res,ds);
        ds.remove(ds.size()-1);
        helper(nums,index+1,target,cursum,res,ds);
    }
}