class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], t = edge[2];
            adj.get(u).add(new int[]{v, t});
            adj.get(v).add(new int[]{u, t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{passingFees[0], 0, 0});

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], city = curr[1], time = curr[2];

            if (city == n - 1) return cost;

            for (int[] next : adj.get(city)) {
                int nei = next[0], t = next[1];
                int newTime = time + t;
                int newCost = cost + passingFees[nei];

                if (newTime <= maxTime && newTime < minTime[nei]) {
                    minTime[nei] = newTime;
                    pq.offer(new int[]{newCost, nei, newTime});
                }
            }
        }

        return -1;
    }
}
