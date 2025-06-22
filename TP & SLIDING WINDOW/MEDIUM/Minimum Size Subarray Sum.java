class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE,r=0,l=0,sum=0;
        while(r<nums.length && l<nums.length){
            sum+=nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}