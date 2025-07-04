class Solution {
    static class Triple{
        int row,col,time;
        Triple(int row, int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;

        Queue<Triple> q=new LinkedList<>();
        int[][] visited=new int[m][n];
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new Triple(i,j,0));
                    visited[i][j]=2;
                }else{
                    visited[i][j]=0;
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        int res=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!q.isEmpty()){
            Triple node=q.poll();
            int row=node.row,col=node.col,time=node.time;
            res=Math.max(res,time);

            for(int i=0;i<4;i++){
                int r=row+drow[i];
                int c=col+dcol[i];
                if(r>=0 && c>=0 && c<n && r<m && visited[r][c]==0 && grid[r][c]==1){
                    q.offer(new Triple(r,c,time+1));
                    visited[r][c]=2;
                    fresh--;
                }
            }
        }
        return fresh==0?res:-1;
    }
}