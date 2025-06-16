class Solution {
    public int maximumDifference(int[] nums) {
        int b=nums[0];
        int p=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>b) p = Math.max(p,nums[i]-b);
            if(nums[i]<b) b=nums[i];
        }
        return p;
    }
}