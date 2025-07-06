class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj= new ArrayList<>();
        int[] indegree=new int[V];
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res=new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            res.add(node);
            
            for(int predecessor : adj.get(node)) {
                indegree[predecessor]--;
                if(indegree[predecessor] == 0) {
                    queue.offer(predecessor);
                }
            }
        }
        return res;
    }
}