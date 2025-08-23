class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        int a = s.length(), b = rev.length();
        int[] prev = new int[b + 1];
        int[] cur = new int[b + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
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