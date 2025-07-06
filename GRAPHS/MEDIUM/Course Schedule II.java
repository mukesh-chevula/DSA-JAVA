class Solution {
    public int[] findOrder(int V, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        int[] indegree=new int[V];
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] res=new int[V];
        int index=0;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            res[index++]=node;
            
            for(int predecessor : adj.get(node)) {
                indegree[predecessor]--;
                if(indegree[predecessor] == 0) {
                    queue.offer(predecessor);
                }
            }
        }
        return index==V?res:new int[0];
    }
}