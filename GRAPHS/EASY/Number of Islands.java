class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    res++;
                    traverse(grid,visited,i,j);
                }
            }
        }
        return res;
    }
    void traverse(char[][] grid, boolean[][] visited, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || visited[i][j]) return;

        visited[i][j] = true;

        traverse(grid, visited, i - 1, j);
        traverse(grid, visited, i + 1, j);
        traverse(grid, visited, i, j - 1);
        traverse(grid, visited, i, j + 1);
    }
}