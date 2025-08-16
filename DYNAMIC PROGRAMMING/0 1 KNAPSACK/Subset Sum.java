class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        Boolean[][] dp = new Boolean[arr.length][sum+1];
        return helper(sum,arr, arr.length - 1, dp);
    }
    static boolean helper(int sum, int arr[], int n, Boolean[][] dp) {
        if (sum == 0) return true;
        if (n < 0) return false;
        if (dp[n][sum] != null) return dp[n][sum];

        boolean not_take = helper(sum, arr, n - 1, dp);

        boolean take = false;
        if (arr[n] <= sum) {
            take = helper(sum - arr[n], arr, n - 1, dp);
        }

        dp[n][sum] = take || not_take;
        return dp[n][sum];
    }
    static Boolean isSubsetSumTabulation(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}