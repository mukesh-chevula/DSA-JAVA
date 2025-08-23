class Solution {
    // Memoization approach
    int countPartitionsMemoization(int[] nums, int d) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) sum += i;
        if ((d + sum) % 2 != 0) return 0;
        int s1 = (d + sum) / 2;
        if (s1 < 0 || s1 > sum) return 0;
        int[][] dp = new int[n][s1 + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(nums, s1, 0, dp);
    }

    private int helper(int[] nums, int remaining, int index, int[][] dp) {
        if (index == nums.length) return remaining == 0 ? 1 : 0;
        if (remaining < 0) return 0;
        if (dp[index][remaining] != -1) return dp[index][remaining];

        int include = helper(nums, remaining - nums[index], index + 1, dp);
        int exclude = helper(nums, remaining, index + 1, dp);

        return dp[index][remaining] = include + exclude;
    }

    // Tabulation approach
    int countPartitionsTabulation(int[] nums, int d) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) sum += i;
        if ((d + sum) % 2 != 0) return 0;
        int s1 = (d + sum) / 2;
        if (s1 < 0 || s1 > sum) return 0;
        int[][] dp = new int[n + 1][s1 + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][s1];
    }
}
