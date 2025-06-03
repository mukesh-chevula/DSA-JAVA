class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0,high=nums.length-1,mid;
        int f=-1,s=-1;

        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target) {
                f=mid;
                high=mid-1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        low=0;
        high=nums.length-1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                s = mid;
                low = mid + 1;

            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int[] res=new int[]{f,s};

        return res;
    }
}