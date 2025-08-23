import java.util.Arrays;

// Class to solve Longest Common Subsequence (LCS) problem using different approaches
class Solution {

    // Recursive approach (no memoization)
    public int longestCommonSubsequenceRecursive(String text1, String text2) {
        int a = text1.length() - 1, b = text2.length() - 1;
        return rec(text1, text2, a, b);
    }

    // Helper recursive function for LCS
    public int rec(String text1, String text2, int a, int b) {
        // Base case: if either string is exhausted
        if (a < 0 || b < 0) {
            return 0;
        }
        // If current characters match, include in LCS
        if (text1.charAt(a) == text2.charAt(b)) {
            return 1 + rec(text1, text2, a - 1, b - 1);
        }
        // Otherwise, try skipping a character from either string
        return Math.max(rec(text1, text2, a - 1, b), rec(text1, text2, a, b - 1));
    }

    // Memoization (Top-down DP) approach
    public int longestCommonSubsequenceMemoization(String text1, String text2) {
        int a = text1.length() - 1, b = text2.length() - 1;
        int[][] dp = new int[a + 1][b + 1];
        // Initialize DP array with -1 (uncomputed)
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(text1, text2, a, b, dp);
    }

    // Helper recursive function for memoization
    public int rec(String text1, String text2, int a, int b, int[][] dp) {
        if (a < 0 || b < 0) {
            return 0;
        }
        // Return cached result if available
        if (dp[a][b] != -1) return dp[a][b];
        if (text1.charAt(a) == text2.charAt(b)) {
            return dp[a][b] = 1 + rec(text1, text2, a - 1, b - 1, dp);
        }
        return dp[a][b] = Math.max(rec(text1, text2, a - 1, b, dp), rec(text1, text2, a, b - 1, dp));
    }

    // Tabulation (Bottom-up DP) approach
    public static int longestCommonSubsequenceTabulation(String text1, String text2) {
        int a = text1.length(), b = text2.length();
        int[][] dp = new int[a + 1][b + 1];
        // Build DP table iteratively
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a][b];
    }

    // Space optimized DP approach
    public static int longestCommonSubsequenceSpaceOptimized(String text1, String text2) {
        int a = text1.length(), b = text2.length();
        // Ensure text2 is not longer than text1 for space optimization
        if (b > a) return longestCommonSubsequenceTabulation(text2, text1);
        int[] prev = new int[b + 1];
        int[] cur = new int[b + 1];
        // Only keep two rows at a time
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(cur[j - 1], prev[j]);
                }
            }
            prev = cur.clone();
        }
        return prev[b];
    }
}