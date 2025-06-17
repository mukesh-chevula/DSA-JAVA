class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        _subsets(nums,0,target,new ArrayList<>(),res);
        return res;
    }

    private static void _subsets(int[] nums,int index,int target,List<Integer> curSet,List<List<Integer>> res) {
        if(target==0) {
            res.add(new ArrayList<>(curSet));
            return;
        }

        
        for (int i=index;i<nums.length;i++) {
            if (i>index&&nums[i]==nums[i-1]) continue;
            if (nums[i] > target) break;

            curSet.add(nums[i]);
            _subsets(nums,i+1,target-nums[i],curSet,res);
            curSet.remove(curSet.size()-1);
        }
    }
}