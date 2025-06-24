class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        int n=nums.length;
        Arrays.sort(nums,(a,b)->a[1]-b[1]);
        int count = 1;
        int finish = nums[0][1];

        for (int i = 1; i < n; i++) {
            if (nums[i][0] >= finish) {
                count++;
                finish = nums[i][1];
            }
        }

        return n-count;
    }
}
