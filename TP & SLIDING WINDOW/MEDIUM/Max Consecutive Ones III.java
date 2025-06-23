class Solution {
    public int longestOnes(int[] nums, int k) {
        int res=0;
        int n=nums.length;
        int l=0,r=0;
        int zc=0;
        while(r<n){
            if(nums[r]==0) zc++;
            while(zc>k){
                if(nums[l]==0) zc--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}