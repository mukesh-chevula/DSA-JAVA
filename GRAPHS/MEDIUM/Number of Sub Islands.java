class Solution {
    int m, n;
    boolean[][] seen;
    int[] moves = new int[]{-1,0,1,0,-1};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;   
        seen = new boolean[m][n];
        int res = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1 && !seen[i][j]){
                    if(dfs(i, j, grid1, grid2)){
                        res++;
                    }
                }
            }
        }    
        return res;
    }

    boolean dfs(int i, int j, int[][] grid1, int[][] grid2){
        if(i < 0 || i == m || j < 0 || j == n || grid2[i][j] == 0 || seen[i][j])
            return true;
        if(grid1[i][j] != grid2[i][j])
            return false;
        
        seen[i][j] = true;
        boolean res = true;
        
        for(int k = 0; k < 4; k++){
            int fi = i + moves[k];
            int fj = j + moves[k+1];
            res &= dfs(fi, fj, grid1, grid2);
        }
        return res;
    }
}