// User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int n) {
        int[] res = new int[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{arr[i], i});
        }

        int rank = 0;
        int lastNum = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int curr = top[0];
            int index = top[1];

            if (lastNum == Integer.MAX_VALUE || curr != lastNum) {
                rank++;
            }

            res[index] = rank;
            lastNum = curr;
        }

        return res;
    }
}