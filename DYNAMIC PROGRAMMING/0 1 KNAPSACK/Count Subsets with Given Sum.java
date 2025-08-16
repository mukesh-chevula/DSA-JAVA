class Solution {
    public int perfectSum(int[] nums, int target) {
        return helper(nums, target, 0);
    }

    public int helper(int[] nums, int remaining, int index){
        if (index == nums.length) {
            return remaining == 0 ? 1 : 0;
        }

        if (remaining < 0) return 0;

        int include = helper(nums, remaining - nums[index], index + 1);
        int exclude = helper(nums, remaining, index + 1);

        return include + exclude;
    }
    public int perfectSumTabulation(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
}
