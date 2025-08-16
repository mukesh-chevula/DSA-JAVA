class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;

        if ((sum & 1) == 1) return false;

        sum /= 2;
        int[][] dp = new int[nums.length][sum + 1];

        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j <= sum; j++)
                dp[i][j] = -1;

        return helper(sum, nums, nums.length - 1, dp) == 1;
    }

    static int helper(int sum, int[] arr, int n, int[][] dp) {
        if (sum == 0) return 1;
        if (n < 0) return 0;
        if (dp[n][sum] != -1) return dp[n][sum];

        int notTake = helper(sum, arr, n - 1, dp);

        int take = 0;
        if (arr[n] <= sum) {
            take = helper(sum - arr[n], arr, n - 1, dp);
        }

        dp[n][sum] = (take == 1 || notTake == 1) ? 1 : 0;
        return dp[n][sum];
    }

    public boolean canPartitionTabulation(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if ((sum & 1) == 1) return false;
        sum /= 2;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) dp[i][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
