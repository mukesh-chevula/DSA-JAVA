//leetcode 18

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null ||nums.length<4) return res;
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int l=j+1,r=nums.length-1;
                while(l<r){
                    long sum= (long) nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        r--;
                        l++;
                        while(l<r && nums[l]==nums[l-1]) l++;
                        while(l<r && nums[r]==nums[r+1]) r--;                        
                    }else if(sum>target) r--;
                    else l++;
                }
            }
        }
        return res;
    }
}