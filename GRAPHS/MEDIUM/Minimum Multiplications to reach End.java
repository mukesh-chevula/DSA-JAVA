// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        if(start == end) return 0;
        Queue<int[]> pq=new LinkedList<>();
        int[] dist = new int[100000]; 
        for(int i = 0;i<100000;i++) dist[i] = (int)(1e9);
        dist[start] = 0; 
        pq.offer(new int[]{0,start});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int node=cur[1],steps=cur[0];
            for(int i:arr) {
                int num = (i * node) % 100000; 
                if(steps + 1 < dist[num]) {
                    dist[num] = steps + 1; 
                    if(num == end) return steps + 1; 
                    pq.offer(new int[]{steps + 1, num}); 
                }
            }
        }
        return -1;
    }
}
