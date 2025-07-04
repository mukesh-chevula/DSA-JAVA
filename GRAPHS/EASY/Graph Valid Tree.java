class Solution {
    static class Pair{
        int node,parent;
        Pair(int node, int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] i:edges){
            int u=i[0],v=i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited=new boolean[n];
        int cc=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(bfs(i, adj, visited)){
                    return false;
                }
                cc++;
            }
        }
        return cc==1;
    }
    private boolean bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Pair> q=new LinkedList<>();
        visited[start] = true;
        q.add(new Pair(start,-1));
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.node;
            int parent = pair.parent;
            
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(new Pair(neighbor, node));
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
