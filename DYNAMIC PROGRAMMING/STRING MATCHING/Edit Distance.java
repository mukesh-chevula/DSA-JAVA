class Solution {
    // Standard DP (Tabulation)
    public int minDistance(String s, String t) {
        int a = s.length(), b = t.length();
        int[][] dp = new int[a + 1][b + 1];
        for (int i = 0; i <= a; i++)
            dp[i][0] = i;
        for (int j = 0; j <= b; j++)
            dp[0][j] = j;

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],
                            Math.min(
                                    dp[i - 1][j - 1],
                                    dp[i][j - 1]));
                }
            }
        }
        return dp[a][b];
    }

    // Memoization (Top-down)
    public int _minDistance(String s, String t) {
        int a = s.length() - 1, b = t.length() - 1;
        int[][] dp = new int[a + 1][b + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return helper(s, t, a, b, dp);
    }

    public int helper(String s, String t, int a, int b, int[][] dp) {
        if (a < 0)
            return b + 1;
        if (b < 0)
            return a + 1;

        if (dp[a][b] != -1)
            return dp[a][b];

        if (s.charAt(a) == t.charAt(b))
            return dp[a][b] = helper(s, t, a - 1, b - 1, dp);

        return dp[a][b] = 1 + Math.min(helper(s, t, a, b - 1, dp),
                Math.min(helper(s, t, a - 1, b, dp), helper(s, t, a - 1, b - 1, dp)));
    }

    // Tabulation with space optimization (using prev and cur arrays)
    public int minDistanceSpaceOptimized(String s, String t) {
        int a = s.length(), b = t.length();
        int[] prev = new int[b + 1];
        int[] cur = new int[b + 1];

        for (int j = 0; j <= b; j++)
            prev[j] = j;

        for (int i = 1; i <= a; i++) {
            cur[0] = i;
            for (int j = 1; j <= b; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    cur[j] = 1 + Math.min(
                            prev[j],
                            Math.min(
                                    prev[j - 1],
                                    cur[j - 1]));
                }
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[b];
    }

    // Tabulation with single array optimization
    public int minDistanceSingleArray(String s, String t) {
        int a = s.length(), b = t.length();
        int[] dp = new int[b + 1];

        for (int j = 0; j <= b; j++)
            dp[j] = j;

        for (int i = 1; i <= a; i++) {
            int prevDiag = dp[0];
            dp[0] = i;
            for (int j = 1; j <= b; j++) {
                int temp = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = prevDiag;
                } else {
                    dp[j] = 1 + Math.min(
                            dp[j],
                            Math.min(
                                    dp[j - 1],
                                    prevDiag));
                }
                prevDiag = temp;
            }
        }
        return dp[b];
    }
}