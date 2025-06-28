// User function Template for Java

class Solution {
    public static long sumBetweenTwoKth(long A[], long N, long k1, long k2) {
        // Your code goes here
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(long i:A) pq.add(i);
        for(long i=0;i<k1;i++){
            pq.poll();
        }
        long sum=0;
        for(long i=k1;i<k2-1;i++){
            sum+=pq.poll();
        }
        return sum;
    }
}


// 4 8 10 12 14 20 22

// 10   20

