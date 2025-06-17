class Solution {

    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        return helper(arr,sum,0,0);
    }
    static boolean helper(int[] arr, int sum, int curSum, int index){
        if(index>=arr.length){
            return curSum==sum;
        }
        if(curSum>sum) return false;
        
        return helper(arr,sum, curSum+arr[index],index+1) || helper(arr,sum, curSum,index+1);
    }
}