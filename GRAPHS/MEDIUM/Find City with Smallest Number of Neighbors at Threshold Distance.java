class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], distanceThreshold + 1);
            dist[i][i] = 0;
        }
        
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            if (weight <= distanceThreshold) {
                dist[from][to] = weight;
                dist[to][from] = weight;
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] > distanceThreshold) continue;
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] <= distanceThreshold) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        int minReachable = n;
        int result = -1;
        
        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachable++;
                }
            }
            
            if (reachable <= minReachable) {
                minReachable = reachable;
                result = i;
            }
        }
        
        return result;
    }
}