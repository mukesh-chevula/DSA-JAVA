class Solution {
    static class Result {
        int cost;
        List<int[]> mst;
        
        Result(int cost, List<int[]> mst) {
            this.cost = cost;
            this.mst = mst;
        }
    }
    
    static Result spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, -1});
        
        boolean[] visited = new boolean[V];
        int res = 0;
        List<int[]> mst = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist = cur[0], node = cur[1], parent = cur[2];
            
            if(visited[node]) continue;
            
            visited[node] = true;
            res += dist;
            
            if(parent != -1) {
                mst.add(new int[]{parent, node, dist});
            }
            
            for(int[] i : adj.get(node)) {
                if(!visited[i[0]]) {
                    pq.offer(new int[]{i[1], i[0], node});
                }
            }
        }
        
        return new Result(res, mst);
    }
}