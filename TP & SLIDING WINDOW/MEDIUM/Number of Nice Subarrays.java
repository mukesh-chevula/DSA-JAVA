class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return _numberOfSubarrays(nums,k)-_numberOfSubarrays(nums,k-1);
    }
    public int _numberOfSubarrays(int[] nums, int k){
        int oddc=0,r=0,l=0,res=0,n=nums.length;

        while(r<n){
            if((nums[r]&1)==1) oddc++;
            while(oddc>k){
                if((nums[l]&1)==1) oddc--;
                l++;
            }
            res+=(r-l+1);
            r++;
        }
        return res;
    }
}