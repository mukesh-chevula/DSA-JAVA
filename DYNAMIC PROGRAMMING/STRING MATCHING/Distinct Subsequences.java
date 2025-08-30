class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        prev[0] = curr[0] = 1;

        for(int i=1;i<=n;i++){
            curr[0]=1;
            for (int j=1; j<=m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    curr[j] = prev[j-1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr.clone();
        }
        return curr[m];
    }
    public int __numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0 ;i<=n;i++) {
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
    public int _numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        if(m<n) return 0;
        int[][] dp = new int[m][n];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return rec(s,t,m-1,n-1, dp);
    }

    public int rec(String s, String t, int a, int b, int[][] dp){
        if(b<0) return 1;
        if(a<0 ) return 0;

        if(dp[a][b]!= -1) return dp[a][b];

        int take = 0;
        if (s.charAt(a) == t.charAt(b)) {
            take = rec(s, t, a-1, b-1, dp);
        }
        int not_take = rec(s, t, a-1, b, dp);

        return dp[a][b] = take + not_take;
    }
}