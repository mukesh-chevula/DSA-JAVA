//leetcode 2149

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int p=0,n=1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                res[n]=nums[i];
                n+=2;
            }else{
                res[p]=nums[i];
                p+=2;
            }
        }
        return res;
    }
}