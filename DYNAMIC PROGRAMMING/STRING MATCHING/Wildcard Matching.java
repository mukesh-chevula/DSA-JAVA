import java.util.Arrays;

class Solution {
    // Dynamic Programming - Space Optimized
    public boolean isMatchDP(String s, String p) {
        int a = s.length(), b = p.length();
        boolean[] prev = new boolean[b + 1];
        boolean[] cur = new boolean[b + 1];
        prev[0] = true;

        for (int j = 1; j <= b; j++) {
            if (p.charAt(j - 1) == '*') {
                prev[j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= a; i++) {
            Arrays.fill(cur, false);
            for (int j = 1; j <= b; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    cur[j] = prev[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    cur[j] = cur[j - 1] || prev[j];
                }
            }
            boolean[] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        return prev[b];
    }

    // Dynamic Programming - Tabulation
    public boolean isMatchTabulation(String s, String p) {
        int a = s.length(), b = p.length();
        boolean[][] mem = new boolean[a + 1][b + 1];
        mem[0][0] = true;
        for (int j = 1; j <= b; j++) {
            if (p.charAt(j - 1) == '*') {
                mem[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    mem[i][j] = mem[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    mem[i][j] = mem[i - 1][j] || mem[i][j - 1];
                }
            }
        }

        return mem[a][b];
    }

    // Recursion + Memoization
    public boolean isMatchMemo(String s, String p) {
        int a = s.length(), b = p.length();
        Boolean[][] mem = new Boolean[a + 1][b + 1];
        return rec(s, p, a - 1, b - 1, mem);
    }

    private boolean rec(String s, String p, int a, int b, Boolean[][] mem) {
        if (a < 0 && b < 0)
            return true;

        if (b < 0)
            return false;

        if (a < 0) {
            for (int k = 0; k <= b; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if (mem[a][b] != null)
            return mem[a][b];

        char pc = p.charAt(b);

        if (pc == s.charAt(a) || pc == '?') {
            return mem[a][b] = rec(s, p, a - 1, b - 1, mem);
        } else if (pc == '*') {
            return mem[a][b] = rec(s, p, a - 1, b, mem) || rec(s, p, a, b - 1, mem);
        }
        return mem[a][b] = false;
    }

    //  Recursion
    public boolean isMatchRec(String s, String p) {
        return recFlat(s, p, s.length() - 1, p.length() - 1);
    }

    private boolean recFlat(String s, String p, int a, int b) {
        if (a < 0 && b < 0)
            return true;

        if (b < 0)
            return false;

        if (a < 0) {
            for (int k = 0; k <= b; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        char pc = p.charAt(b);

        if (a >= 0 && (pc == s.charAt(a) || pc == '?')) {
            return recFlat(s, p, a - 1, b - 1);
        } else if (pc == '*') {
            return recFlat(s, p, a - 1, b) || recFlat(s, p, a, b - 1);
        }
        return false;
    }
}
