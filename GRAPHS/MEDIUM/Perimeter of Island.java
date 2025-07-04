class Solution {
    public int islandPerimeter(int[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       int ans=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            int value=4;
            if(grid[i][j]==1){
                if(i-1>=0 && grid[i-1][j]==1)
                value--;
                 if(j-1>=0 && grid[i][j-1]==1)
                value--;
                 if(i+1<n && grid[i+1][j]==1)
                value--;
                 if(j+1<m && grid[i][j+1]==1)
                value--;

                ans+=value;
            }
        }
       }
       return ans;
    }
}