class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        dfs(adj, src, dist, 0);
        return dist;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] dist, int curDist) {
        for (Integer child : adj.get(node)) {
            if (dist[child] == -1 || dist[child] > curDist + 1) {
                dist[child] = curDist + 1;
                dfs(adj, child, dist, curDist + 1);
            }
        }
    }
}
