class Solution {
    // DP with rolling arrays
    public boolean isMatch(String s, String p) {
        int a = s.length(), b = p.length();
        boolean[] prev = new boolean[b + 1];
        boolean[] cur = new boolean[b + 1];
        prev[0] = true;

        for (int j = 1; j <= b; j++) {
            if (p.charAt(j - 1) == '*')
                prev[j] = prev[j - 2];
        }

        for (int i = 1; i <= a; i++) {
            Arrays.fill(cur, false);
            for (int j = 1; j <= b; j++) {
                char pc = p.charAt(j - 1);
                if (pc == s.charAt(i - 1) || pc == '.') {
                    cur[j] = prev[j - 1];
                } else if (pc == '*') {
                    char pre = p.charAt(j - 2);
                    boolean zero = cur[j - 2];
                    boolean more = (s.charAt(i - 1) == pre || pre == '.') && prev[j];
                    cur[j] = zero || more;
                }
            }
            boolean[] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        return prev[b];
    }

    // DP with 2D array
    public boolean isMatchDP(String s, String p) {
        int a = s.length(), b = p.length();
        boolean[][] dp = new boolean[a + 1][b + 1];
        dp[0][0] = true;

        for (int j = 1; j <= b; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                char pc = p.charAt(j - 1);
                if (pc == s.charAt(i - 1) || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char prev = p.charAt(j - 2);
                    boolean zero = dp[i][j - 2];
                    boolean more = (s.charAt(i - 1) == prev || prev == '.') && dp[i - 1][j];
                    dp[i][j] = zero || more;
                }
            }
        }

        return dp[a][b];
    }

    // Top-down recursion with memoization
    public boolean isMatchMemo(String s, String p) {
        int a = s.length(), b = p.length();
        Boolean[][] dp = new Boolean[a + 1][b + 1];
        return recMemo(s, p, a - 1, b - 1, dp);
    }

    public boolean recMemo(String s, String p, int a, int b, Boolean[][] dp) {
        if (a < 0 && b < 0)
            return true;
        if (b < 0)
            return false;
        if (a < 0) {
            while (b >= 0) {
                if (p.charAt(b) == '*')
                    b -= 2;
                else
                    return false;
            }
            return true;
        }
        if (dp[a][b] != null)
            return dp[a][b];

        char pc = p.charAt(b);
        if (pc == s.charAt(a) || pc == '.') {
            return dp[a][b] = recMemo(s, p, a - 1, b - 1, dp);
        } else if (pc == '*') {
            if (b == 0)
                return false;
            char prev = p.charAt(b - 1);
            boolean zero = recMemo(s, p, a, b - 2, dp);
            boolean more = (s.charAt(a) == prev || prev == '.') && recMemo(s, p, a - 1, b, dp);
            return dp[a][b] = zero || more;
        }
        return dp[a][b] = false;
    }

    // Flat recursion (no memoization)
    public boolean isMatchRec(String s, String p) {
        return recFlat(s, p, s.length() - 1, p.length() - 1);
    }

    public boolean recFlat(String s, String p, int a, int b) {
        if (a < 0 && b < 0)
            return true;
        if (b < 0)
            return false;
        if (a < 0) {
            while (b >= 0) {
                if (p.charAt(b) == '*')
                    b -= 2;
                else
                    return false;
            }
            return true;
        }

        char pc = p.charAt(b);
        if (pc == s.charAt(a) || pc == '.') {
            return recFlat(s, p, a - 1, b - 1);
        } else if (pc == '*') {
            if (b == 0)
                return false;
            char prev = p.charAt(b - 1);
            boolean zero = recFlat(s, p, a, b - 2);
            boolean more = (s.charAt(a) == prev || prev == '.') && recFlat(s, p, a - 1, b);
            return zero || more;
        }
        return false;
    }
}