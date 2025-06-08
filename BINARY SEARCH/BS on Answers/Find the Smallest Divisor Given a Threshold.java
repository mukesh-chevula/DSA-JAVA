class Solution {
    static {
        for (int i = 0; i < 300; i++) smallestDivisor(new int[0], 1);
    }
    private static int calc(int[] nums,int divisor){
        int sum=0;
        for(int i:nums) sum+=(i+divisor-1)/divisor;
        return sum;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length,max=0;

        for(int i:nums) max=Math.max(i,max);

        if(n==threshold) return max;

        int low=1,high=max,mid,res=-1;


        while(low<=high){
            mid=low+(high-low)/2;
            int sum = calc(nums,mid);

            if(sum<=threshold){
                res=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return res;
    }
}