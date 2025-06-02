//Leetcode 48
//TC O(n^2)
// SC O(1)

class Solution {
    public void rotate(int[][] matrix) {
        int temp;
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int[] row: matrix){
            for(int i=0;i<row.length/2;i++){
                temp=row[row.length-i-1];
                row[row.length-i-1]=row[i];
                row[i]=temp;
            }
        }
    }
}