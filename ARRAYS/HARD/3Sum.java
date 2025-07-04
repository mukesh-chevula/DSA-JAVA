//leetcode 15

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;

            int l=i+1,r=nums.length-1;
            while(r>l){
                if(nums[i]+nums[l]+nums[r]==0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    r--;
                    l++;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }else if(nums[i]+nums[l]+nums[r]>0) r--;
                else l++;
            }
        }
        return res;
    }
}