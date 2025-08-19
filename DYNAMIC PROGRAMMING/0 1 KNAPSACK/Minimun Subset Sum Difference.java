class Solution {
    public int minDifference(int[] nums) {
        int sum=0;
        for(int i: nums) {
            sum+=i;
        }
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int res=Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;i++){
            if(dp[n][i]==true){
                res=Math.min(res, Math.abs(sum-2*i));
            }
        }
        return res;
    }
}