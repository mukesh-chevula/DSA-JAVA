class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length][W + 1];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return helper(W, val, wt, val.length - 1, dp);
    }
    
    static int helper(int W, int val[], int wt[], int n, int[][] dp) {
        if(n == 0) {
            if(wt[0] <= W) return val[0];
            return 0;
        }
        
        if(dp[n][W] != -1) return dp[n][W];
        
        int not_take = helper(W, val, wt, n-1, dp);
        
        int take = 0;
        if(wt[n] <= W) {
            take = val[n] + helper(W-wt[n], val, wt, n-1, dp);
        }
        
        return dp[n][W] = Math.max(take, not_take);
    }
}