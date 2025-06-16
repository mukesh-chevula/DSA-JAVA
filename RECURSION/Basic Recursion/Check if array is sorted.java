class Solution {
    public boolean isSorted(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private boolean helper(int[] nums, int start, int end) {
        if (start >= end) {
            return true; 
        }

        int mid = start + (end - start) / 2;

        return helper(nums, start, mid) &&
               helper(nums, mid + 1, end) &&
               nums[mid] <= nums[mid + 1];
    }
}