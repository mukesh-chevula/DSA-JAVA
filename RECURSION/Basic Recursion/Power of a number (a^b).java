class Solution {
    public double myPow(double x, int n) {
        if(x==0 || n==1) return x;
        if(n==0) return 1;
        if(n<0){
            x=1/x;
            n=-n;
        }
        return helper(x,n);
    }
    public double helper(double a,int b){
        if(b==0) return 1;
        if(b==1) return a;
        if(b%2==0) {
            double half = helper(a, b/2);
            return half * half;
        }
        double half = helper(a, b/2);
        return a * half * half;
    }
}
