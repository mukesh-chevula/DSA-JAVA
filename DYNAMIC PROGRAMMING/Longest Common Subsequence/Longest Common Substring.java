class Solution {

    // Tabulation (Bottom-up DP) approach for Longest Common Substring
    public static int longestCommonSubstringTabulation(String text1, String text2) {
        int a = text1.length(), b = text2.length();
        int[][] dp = new int[a + 1][b + 1];
        int maxLen = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }

    // Space optimized DP approach for Longest Common Substring
    public static int longestCommonSubstringSpaceOptimized(String text1, String text2) {
        int a = text1.length(), b = text2.length();
        int[] prev = new int[b + 1];
        int[] cur = new int[b + 1];
        int maxLen = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                    maxLen = Math.max(maxLen, cur[j]);
                } else {
                    cur[j] = 0;
                }
            }
            prev = cur.clone();
        }
        return maxLen;
    }
}
