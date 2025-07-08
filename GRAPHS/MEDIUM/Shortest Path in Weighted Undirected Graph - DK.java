class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->{
                if(a[1]!=b[1]) return a[1]-b[1];
                return a[0]-b[0];
            });
        int[] res=new int[n+1];
        int[] parent=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        int src=1;
        res[src]=0;
        parent[src]=0;
        
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            int node=p[0];
            int dist=p[1];
            
            if(dist > res[node]) continue;
            
            for(int[] child:adj.get(node)){
                int ch=child[0],wt=child[1];
                if(res[ch] > dist+wt) {
                    res[ch]=dist+wt;
                    parent[ch]=node;
                    pq.offer(new int[]{ch,res[ch]});
                }
            }
        }
       
        if (dist[n] == Integer.MAX_VALUE) return Arrays.asList(-1);

        List<Integer> path = new ArrayList<>();
        int cur = n;
        while (cur != parent[cur]) {
            path.add(cur);
            cur = parent[cur];
        }
        path.add(1);
        Collections.reverse(path);

        List<Integer> result = new ArrayList<>();
        result.add(dist[n]);
        result.addAll(path);
        return result;
    }
}