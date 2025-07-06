class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] i:edges){
            int u=i[0],v=i[1];
            adj.get(u).add(v);
        }
        
        boolean[] visited= new boolean[V];
        boolean[] rec= new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i, adj, visited,rec)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int start, List<List<Integer>> adj, boolean[] visited, boolean[] rec) {
        visited[start] = true;
        rec[start]=true;
        
        for (int neighbor : adj.get(start)) {
            if (!visited[neighbor]) {
                if(dfs(neighbor,adj,visited,rec)) return true;
            } else if(rec[neighbor]){
                return true;
            }
        }
        
        rec[start]=false;
        return false;
    }
}