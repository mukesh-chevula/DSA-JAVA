class Solution {
    static{
        for(int i=0;i<=300;i++) splitArray(new int[0],1);
    }
    public static int calc(int[] nums, int pages) {
        int n = nums.length;
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if ((pagesStudent + nums[i]) <= pages) {
                pagesStudent += nums[i];
            } else {
                students++;
                pagesStudent = nums[i];
            }
        }
        return students;
    }

    public static int splitArray(int[] nums, int k) {
        if (k > nums.length) return -1;

        int low=0,high=0;

        for(int i:nums){
            low=Math.max(i,low);
            high+=i;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = calc(nums, mid);
            if (students > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}