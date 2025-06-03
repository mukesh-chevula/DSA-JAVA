class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1,mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]> target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }

    //Recursion
    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    public int binarySearch(int[] nums,int target,int low,int high){
        if(low>high) return -1;
        int mid = low + (high-low)/2;

        if(nums[mid]==target) return mid;
        else if(nums[mid]>target) return binarySearch(nums,target,low,mid-1);
        else return binarySearch(nums,target,mid+1,high);
    }
}