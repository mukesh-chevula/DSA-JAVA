class Solution {
    public int floor(int[] nums, int x) {
        int low = 0, high = nums.length - 1, mid;
        int floor = -1; 

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == x) return x;
            else if (nums[mid] > x) high = mid - 1;
            else {
                floor = nums[mid]; 
                low = mid + 1;
            }
        }
        return floor; 
    }

    public int ceil(int[] nums, int x) {
        int low = 0, high = nums.length - 1, mid;
        int ceil = -1; 

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == x) return x;
            else if (nums[mid] > x) {
                ceil = nums[mid];
                high = mid - 1;
            } else low = mid + 1;
        }
        return ceil; 
    }
}