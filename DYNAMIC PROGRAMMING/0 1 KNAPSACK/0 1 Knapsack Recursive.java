class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        return helper(W,val,wt,val.length-1);
    }
    static int helper(int W, int val[], int wt[],int n){
        if(n==0) {
            if(wt[0]<=W) return val[0];
            return 0;
        }
        
        if(wt[n]<=W){
            return Math.max(val[n]+helper(W-wt[n],val,wt,n-1),helper(W,val,wt,n-1));
        }
        return helper(W,val,wt,n-1);
    }
}