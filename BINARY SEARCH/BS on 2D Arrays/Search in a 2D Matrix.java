class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0,high=m*n-1;
        int mid,midval;
        while(low<=high){
            mid=low+(high-low)/2;
            midval=matrix[mid / n][mid % n];

            if(midval==target) return true;
            else if(midval>target) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}