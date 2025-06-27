import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); 
        Map<Integer, Integer> count = new HashMap<>(); 
        int[] res = new int[n - k + 1];
        int index = 0;

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        res[index++] = pq.peek();

        for (int i = k; i < n; i++) {
            pq.add(nums[i]);
            
            count.put(nums[i - k], count.getOrDefault(nums[i - k], 0) + 1);
            
            while (count.containsKey(pq.peek()) && count.get(pq.peek()) > 0) {
                count.put(pq.peek(), count.get(pq.peek()) - 1);
                pq.poll();
            }

            res[index++] = pq.peek();
        }

        return res;
    }
}
