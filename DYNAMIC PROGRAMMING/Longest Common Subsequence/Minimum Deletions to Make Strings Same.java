class Solution {
    public int minDistance(String str1, String str2) {
        int a = str1.length(), b = str2.length();
        return a+b-2*LCS(str1,str2,a,b);
    }

    public static int LCS(String text1, String text2, int a, int b) {
        if (b > a) return LCS(text2, text1, b, a);
        int[] prev = new int[b + 1];
        int[] cur = new int[b + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(cur[j - 1], prev[j]);
                }
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[b];
    }
}
