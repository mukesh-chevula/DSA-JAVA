class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        _subsets(nums,0,new ArrayList<>(),res);
        return res;
    }

    private static void _subsets(int[] nums,int index,List<Integer> curSet,List<List<Integer>> res) {
        res.add(new ArrayList<>(curSet));
        
        for (int i=index;i<nums.length;i++) {
            if (i>index&&nums[i]==nums[i-1]) continue;

            curSet.add(nums[i]);
            _subsets(nums,i+1,curSet,res);
            curSet.remove(curSet.size()-1);
        }
    }
}
