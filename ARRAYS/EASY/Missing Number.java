class Solution {
    public int missingNumber(int[] nums) {
        //summation apporoach
        int n = nums.length+1;
        int sum = n*(n-1)/2;
        for(int i:nums) sum-=i;
        return sum;
    }
    public int missingNumber(int[] nums) {
        //XOR 
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}