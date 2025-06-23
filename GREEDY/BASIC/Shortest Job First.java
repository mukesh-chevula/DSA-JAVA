// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        
        int res=0;
        int curTime=0;
        
        for(int i:bt){
            res+=curTime;
            curTime+=i;
        }
        return res;
    }
}
