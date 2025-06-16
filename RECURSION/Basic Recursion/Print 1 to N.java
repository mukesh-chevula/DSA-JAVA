class Solution{
    public static void helper(int n, int k){
        if(k==n) return;
        System.out.println(k);
        return helper(n, k + 1);
    }
    public static void print1toN(int n){
        helper(n,1);
    }
}