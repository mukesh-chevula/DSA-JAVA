class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0, src, 0});

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1], stop = curr[2];

            if (node == dst) return cost;
            if (stop > k || stop > stops[node]) continue;
            stops[node] = stop;

            for (int[] next : adj.get(node)) {
                int nei = next[0], wt = next[1];
                pq.offer(new int[]{cost + wt, nei, stop + 1});
            }
        }
        return -1;
    }
}