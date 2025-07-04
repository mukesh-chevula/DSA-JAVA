class Solution {
    static class Triple{
        int row,col,dist;
        Triple(int row, int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length,n=mat[0].length;

        Queue<Triple> q=new LinkedList<>();

        boolean[][] visited=new boolean[m][n];
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new Triple(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!q.isEmpty()){
            Triple node=q.poll();
            int row=node.row,col=node.col,dist=node.dist;
            visited[row][col]=true;
            res[row][col]=dist;
            for(int i=0;i<4;i++){
                int r=row+drow[i];
                int c=col+dcol[i];
                if(r>=0 && c>=0 && c<n && r<m && visited[r][c]==false && mat[r][c]==1){
                    q.offer(new Triple(r,c,dist+1));
                    visited[r][c]=true;
                }
            }
        }
        return res;
    }
}