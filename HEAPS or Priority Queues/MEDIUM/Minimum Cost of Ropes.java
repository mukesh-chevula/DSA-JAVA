class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);
        for(int i:arr) pq.add(i);
        int res=0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int cost = first + second;
            res += cost;

            pq.add(cost);
        }
        return res;
    }
}