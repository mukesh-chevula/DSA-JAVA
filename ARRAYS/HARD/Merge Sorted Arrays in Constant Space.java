//leetcode 88

class Solution {
    private void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private int nextGap(int gap) {
        if (gap == 1) { // If the gap is 1, return 0 to terminate the loop
            return 0;
        }
        // Calculate the next gap by halving the current gap and rounding up
        return (int) Math.ceil((double) gap / 2.0);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n;
        int gap = total / 2; 

        while (gap > 0) {
            for (int i = 0; i < total - gap; i++) {
                int next = i + gap; 

                // Case 1: Both elements are in nums1
                if (i < m && next < m && (nums1[i] > nums1[next])) {
                    swap(i, next, nums1);
                }
                // Case 2: One element is in nums1 and the other is in nums2
                else if (i < m && next >= m && (nums1[i] > nums2[next - m])) {
                    int tmp = nums1[i];
                    nums1[i] = nums2[next - m];
                    nums2[next - m] = tmp;
                }
                // Case 3: Both elements are in nums2
                else if (i >= m && next >= m && nums2[i - m] > nums2[next - m]) {
                    swap(i - m, next - m, nums2);
                }
            }
            gap = nextGap(gap);
        }

        for (int i = m; i < total; i++) {
            nums1[i] = nums2[i - m];
        }
    }
}