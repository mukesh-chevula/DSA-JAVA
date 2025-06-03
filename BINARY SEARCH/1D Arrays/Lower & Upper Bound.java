class Solution {
    public static int lowerBound(int[] nums, int x) {
        // Return smallest index i where nums[i] >= x
        int low = 0, high = nums.length - 1, lb = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= x) {
                lb = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lb;
    }

    public static int upperBound(int[] nums, int x) {
        // Return largest index i where nums[i] > x
        int low = 0, high = nums.length - 1, ub = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > x) {
                ub = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ub;
    }
}