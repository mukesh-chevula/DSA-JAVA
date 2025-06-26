class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            maxHeap.offer(i);
            if(maxHeap.size()>k) maxHeap.poll();
        }
        return maxHeap.poll();
    }
}