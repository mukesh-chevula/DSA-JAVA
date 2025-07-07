class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dx = {0, 1, -1, 0, 1, 1, -1, -1};
        int[] dy = {1, 0, 0, -1, 1, -1, -1, 1};
        int n=grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0,1});
        boolean[][] visited=new boolean[n][n];
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] p=q.poll();
            int x=p[0],y=p[1],dist=p[2];
            if(x==n-1 && y==n-1) return dist;
            for(int i = 0; i < 8; i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && grid[nx][ny]==0){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny,dist+1});
                }
            }
        }
        return -1;
    }
}
