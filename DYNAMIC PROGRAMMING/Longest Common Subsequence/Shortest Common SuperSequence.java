class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int a = str1.length(), b = str2.length();
        int[][] dp = new int[a + 1][b + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int r = a, c = b;
        StringBuilder sb = new StringBuilder();
        while (r > 0 && c > 0) {
            if (str1.charAt(r - 1) == str2.charAt(c - 1)) {
                sb.append(str1.charAt(r - 1));
                r--;
                c--;
            } else {
                if (dp[r - 1][c] >= dp[r][c - 1]) {
                    sb.append(str1.charAt(r - 1));
                    r--;
                } else {
                    sb.append(str2.charAt(c - 1));
                    c--;
                }
            }
        }
        while (r > 0) {
            sb.append(str1.charAt(r - 1));
            r--;
        }
        while (c > 0) {
            sb.append(str2.charAt(c - 1));
            c--;
        }
        return sb.reverse().toString();
    }
}