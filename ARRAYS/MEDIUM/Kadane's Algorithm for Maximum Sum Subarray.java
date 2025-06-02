class Solution {
    public int maxSubArray(int[] nums) {
        int cursum=0,maxsum=nums[0];

        for (int i=0;i<nums.length;i++){
            if(cursum<0){
               cursum=0;
            }
            cursum +=nums[i];
            maxsum=Math.max(cursum,maxsum);
        }
        return maxsum;        
    }
    public static void printMaxSumSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int maxSum = arr[0];      
        int currentSum = arr[0];
        int start = 0;           
        int end = 0;        
        int tempStart = 0;      
        for (int i = 1; i < arr.length; i++) {
            if (currentSum < 0) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i]; 
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("Maximum sum subarray is:");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nMaximum sum: " + maxSum);
    }
}