class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        int[][] effort=new int[m][n];
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        for(int[] e:effort) Arrays.fill(e,Integer.MAX_VALUE);
        effort[0][0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[]cur=pq.poll();
            int cost=cur[0],x=cur[1],y=cur[2];
            if(cost>effort[x][y]) continue;

            if(x==m-1 && y==n-1) return cost;

            for(int i=0;i<4;i++){
                int nx=x+dx[i],ny=y+dy[i];

                if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
                int neffort=Math.max(effort[x][y],Math.abs(heights[x][y]-heights[nx][ny]));

                if(neffort<effort[nx][ny]){
                    effort[nx][ny]=neffort;
                    pq.add(new int[]{neffort,nx,ny});
                }
            }
        }
        return effort[m-1][n-1];
    }
}