// User function Template for Java
// Unbounded Knapsack implementations
class Solution {
    // Tabulation - 1D DP
    static int knapSack(int val[], int wt[], int W) {
        int n = val.length;
        int[] dp = new int[W + 1];
    
        for (int w = wt[0]; w <= W; w++) {
            dp[w] = (w / wt[0]) * val[0];
        }
    
        for (int j = 1; j < n; j++) {
            for (int w = wt[j]; w <= W; w++) {
                dp[w] = Math.max(dp[w], val[j] + dp[w - wt[j]]);
            }
        }
    
        return dp[W];
    }

    // Tabulation - 2D DP
    static int knapSack2D(int val[], int wt[], int W) {
        int n = val.length;
        int[][] dp = new int[W + 1][n];
    
        for (int w = 0; w <= W; w++) {
            dp[w][0] = (w / wt[0]) * val[0];
        }
    
        for (int j = 1; j < n; j++) { 
            for (int w = 0; w <= W; w++) {
                int not_take = dp[w][j - 1];
                int take = Integer.MIN_VALUE;
                if (wt[j] <= w) {
                    take = val[j] + dp[w - wt[j]][j];
                }
                dp[w][j] = Math.max(take, not_take);
            }
        }
    
        return dp[W][n - 1];
    }

    // Memoization
    static int knapSackMemo(int val[], int wt[], int W) {
        int n = val.length - 1;
        int[][] dp = new int[W + 1][n + 1];
        for (int[] i : dp) java.util.Arrays.fill(i, -1);
        return knapSackMemoHelper(W, val, wt, n, dp);
    }
    static int knapSackMemoHelper(int W, int val[], int wt[], int n, int[][] dp) {
        if (n == 0) {
            return dp[W][n] = (W / wt[0]) * val[0];
        }
        if (dp[W][n] != -1) return dp[W][n];
        int not_take = knapSackMemoHelper(W, val, wt, n - 1, dp);
        int take = Integer.MIN_VALUE;
        if (wt[n] <= W) {
            take = val[n] + knapSackMemoHelper(W - wt[n], val, wt, n, dp);
        }
        return dp[W][n] = Math.max(take, not_take);
    }

    // Flat Recursion (no memoization)
    static int knapSackRecursive(int val[], int wt[], int W, int n) {
        if (n == 0) {
            return (W / wt[0]) * val[0];
        }
        int not_take = knapSackRecursive(val, wt, W, n - 1);
        int take = Integer.MIN_VALUE;
        if (wt[n] <= W) {
            take = val[n] + knapSackRecursive(val, wt, W - wt[n], n);
        }
        return Math.max(take, not_take);
    }
}