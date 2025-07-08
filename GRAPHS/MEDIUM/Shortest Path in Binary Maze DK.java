class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dx = {0, 1, -1, 0, 1, 1, -1, -1};
        int[] dy = {1, 0, 0, -1, 1, -1, -1, 1};
        int n = grid.length;
        
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        if(n == 1) return 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 1});
        
        int[][] dist = new int[n][n];
        for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][0] = 1;
        
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int x = p[0], y = p[1], curdist = p[2];
            
            if(x == n-1 && y == n-1) return curdist;
            if(curdist > dist[x][y]) continue;
            
            for(int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0){
                    int newDist = curdist + 1;
                    if(newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        pq.offer(new int[]{nx, ny, newDist});
                    }
                }
            }
        }
        return -1;
    }
}
