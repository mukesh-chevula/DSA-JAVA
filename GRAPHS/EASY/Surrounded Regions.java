class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m=board.length,n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && !visited[0][i]){
                dfs(board,0,i,visited);
            }
            if (board[m-1][i]=='O' && !visited[m-1][i]) {
                dfs(board, m-1, i, visited);
            }
        }
        for(int i=0;i<m;i++){
            if (board[i][n-1] == 'O' && !visited[i][n-1]) {
                dfs(board, i, n-1, visited);
            }
            if(board[i][0]=='O' && !visited[i][0]){
                dfs(board,i,0,visited);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    void dfs(char[][] board,int i, int j, boolean[][] visited){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O' || visited[i][j]) {
            return;
        }
        visited[i][j]=true;

        dfs(board,i-1,j,visited);
        dfs(board,i+1,j,visited);
        dfs(board,i,j-1,visited);
        dfs(board,i,j+1,visited);
    }
}