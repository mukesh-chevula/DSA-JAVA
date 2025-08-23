class Solution {
    public int LongestRepeatingSubsequence(String s) {
        int n = s.length();
        int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && s.charAt(i - 1) == s.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(cur[j - 1], prev[j]);
                }
            }
            prev = cur.clone();
        }
        return prev[n];
    }
}
