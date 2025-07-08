class Solution {
    public int countPaths(int n, int[][] edges) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        final int MOD = 1_000_000_007;
        long[] ways=new long[n];
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        ways[0]=1;
        dist[0]=0;

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] cur=pq.poll();
            long curdist=cur[0];
            int curnode=(int)cur[1];
            if(curdist>dist[curnode]) continue;
            for(int[] ch:adj.get(curnode)){
                int child=ch[0],wt=ch[1];
                long newdist = curdist + wt;
                if(dist[child]>newdist){
                    dist[child]=newdist;
                    ways[child]=ways[curnode];
                    pq.offer(new long[]{dist[child],child});
                }else if (dist[child]==newdist){
                    ways[child]=(ways[child]+ways[(int)curnode]) % MOD;
                }
            }
        }
        return (int)ways[n-1];

    }
}