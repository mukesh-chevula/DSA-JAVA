class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area=dfs(grid,i,j);
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }

    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        return 1 + dfs(grid, i+1, j) 
                + dfs(grid, i-1, j) 
                + dfs(grid, i, j+1)
                + dfs(grid, i, j-1);
    }
}