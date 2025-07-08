class Solution {
    public void floydWarshall(int[][] dist) {
        int V = dist.length;
        final int INF = (int) 1e8;

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(dist[i][k] != 1e8 && dist[k][j]!= 1e8)
                    dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
