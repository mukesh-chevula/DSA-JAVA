class Solution {
    static class Pair{
        int node,parent;
        Pair(int node, int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] i:edges){
            int u=i[0],v=i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] visited= new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }
}