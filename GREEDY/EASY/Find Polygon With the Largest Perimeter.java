class Solution {
    public long largestPerimeter(int[] nums) {
        long sum = 0,max = -1;
        Arrays.sort(nums);
        sum=nums[0]+nums[1];
        int n = nums.length;
        for(int i=2;i<n;i++){
            if(sum > nums[i]) { max = sum + nums[i]; }
            sum += nums[i];
        }
        return max;
    }
}
