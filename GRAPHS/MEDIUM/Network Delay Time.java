class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            int node=p[0];
            int curdist=p[1];
            
            if(curdist > dist[node]) continue;
            
            for(int[] child : adj.get(node)){
                int ch = child[0], wt = child[1];
                if(dist[ch] > curdist + wt) {
                    dist[ch] = curdist + wt;
                    pq.offer(new int[]{ch, dist[ch]});
                }
            }
        }
        int max = 0;
        for(int i=1;i<=n;i++) {
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}