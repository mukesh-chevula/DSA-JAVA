class Solution{
    public int _binarySearch(int[] nums, int l, int h,int target){
        if(l>h) return -1;
        int m=l+(h-l)/2;
        if(nums[m]==target) return m;
        else if(nums[m]>target) return _binarySearch(nums,l,m-1,target);
        else return _binarySearch(nums,m+1,h,target);
    }
    public int binarySearch(int[] nums, int target){
        return _binarySearch(nums,0,nums.length-1,target);
    }
}