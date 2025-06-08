class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        if(nums[1] != nums[0]) return nums[0];
        
        if(nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];

        int low = 1, high = nums.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if the middle element is the single non-duplicate element.
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            // If the middle index is odd and the element matches the previous one,
            // or if the middle index is even and the element matches the next one,
            // move the search to the right half.
            // Otherwise, move the search to the left half.
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1])
                    || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}