class Solution {
    
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int processedNodes = 0;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            processedNodes++;
            
            for(int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        return processedNodes != V;
    }
}
