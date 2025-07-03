class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int bst = catalan(n, dp);

        return bst;
    }

    private int catalan(int n, int[] dp) {
        if (n <= 0)
            return 1;

        if (dp[n - 1] != -1) {
            return dp[n - 1];
        }

        dp[n - 1] = 0;

        for (int i = 1; i <= n; i++) {
            dp[n - 1] += catalan(i - 1, dp) * catalan(n - i, dp);
        }

        return dp[n - 1];
    }
}