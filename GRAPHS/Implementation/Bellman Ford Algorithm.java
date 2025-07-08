// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist=new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src]=0;
        for(int i=0;i<V;i++){
            for(int[] edge:edges){
                int u=edge[0],v=edge[1],wt=edge[2];
                if(dist[u]!=1e8 && dist[u]+wt<dist[v]) dist[v]=dist[u]+wt;
            }
        }
        for(int[] edge:edges){
            int u=edge[0],v=edge[1],wt=edge[2];
            if(dist[u]!=1e8 &&  dist[u]+wt<dist[v]) return new int[]{-1};
        }
        return dist;
    }
}
