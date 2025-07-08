class Solution {
    class Pair{
        int node,dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int[] res=new int[V];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[src]=0;
        
        pq.offer(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.node;
            int dist=p.dist;
            
            if(dist > res[node]) continue;
            
            for(int[] child:adj.get(node)){
                int ch=child[0],wt=child[1];
                if(res[ch] > dist+wt) {
                    res[ch]=dist+wt;
                    pq.offer(new Pair(ch,res[ch]));
                }
            }
        }
        return res;
    }
}