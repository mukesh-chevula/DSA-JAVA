class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] i:edges){
            int u=i[0],v=i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[n];
        q.offer(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            if(node==destination) return true;
            for(Integer i:adj.get(node)){
                if(!visited[i]) {
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }
        return false;
    }
}