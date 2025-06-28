class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(
                Math.sqrt(b[0] * b[0] + b[1] * b[1]),
                Math.sqrt(a[0] * a[0] + a[1] * a[1])
            )
        );
        for(int[] i:points){
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res=new int[k][2];
        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }
        return res;
    }
}