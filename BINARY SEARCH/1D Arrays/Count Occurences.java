class Solution{
    public static int countOccurences(int[] nums, int target){
        //nums={2, 2 , 3 , 3 , 3 , 3 , 4}
        //x=2
        int low=0,high=nums.length-1,mid,c=0;

        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target){
                c++;
                low++;
                high--;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
            return c;
        }
    }
}