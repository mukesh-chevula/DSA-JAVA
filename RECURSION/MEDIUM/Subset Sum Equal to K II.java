class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        return helper(nums,target, 0,0);
    }
    
    public int helper(int[] nums, int target, int index, int curSum){
        if(index>=nums.length){
            return curSum==target?1:0;
        }
        if(curSum==target) return 1;
        
        return helper(nums,target,index+1,curSum+nums[index])+helper(nums,target,index+1,curSum);
    }
}