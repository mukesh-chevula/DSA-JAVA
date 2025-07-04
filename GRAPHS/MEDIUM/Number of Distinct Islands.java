class Solution {
    public int countDistinctIslands(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        Set<String> set=new HashSet<>();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1&&!visited[i][j]) {
                    StringBuilder shape=new StringBuilder();
                    dfs(grid,visited,i,j,i,j,shape);
                    set.add(shape.toString());
                }
            }
        }
        return set.size();
    }
    
    private void dfs(int[][] grid,boolean[][] visited,int i,int j,
                     int baseI,int baseJ,StringBuilder shape) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||
            visited[i][j]||grid[i][j]==0) return;
        
        visited[i][j]=true;
        shape.append((i-baseI)+","+(j-baseJ)+";");
        
        dfs(grid,visited,i+1,j,baseI,baseJ,shape);
        dfs(grid,visited,i-1,j,baseI,baseJ,shape);
        dfs(grid,visited,i,j+1,baseI,baseJ,shape);
        dfs(grid,visited,i,j-1,baseI,baseJ,shape);
    }
}