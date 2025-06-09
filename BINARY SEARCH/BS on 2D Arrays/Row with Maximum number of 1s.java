// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int m=arr.length,n=arr[0].length;
        int maxC=0;
        int maxIndex=-1;
        for(int i=0;i<arr.length;i++){
            int first=-1;
            int low=0,high=n-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                
                if(arr[i][mid]==1){
                    first=mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            if (first!=-1) {
                int countOfOnes=n-first;
                if (countOfOnes>maxC) {
                    maxC=countOfOnes;
                    maxIndex=i;
                }
            }
        }
        return maxIndex;
    }
}