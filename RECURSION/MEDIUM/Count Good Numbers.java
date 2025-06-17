class Solution {
    static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evens=(n+1)/2;
        long odds=n/2;

        return (int)((modPow(4,odds,MOD)*modPow(5,evens,MOD))%MOD);
    }
    public long modPow(long base, long exp, long mod){
        if(exp==0) return 1;
        long temp=modPow(base,exp/2,mod);

        if(exp%2==0) return (temp*temp)%mod;
        else return (base*temp*temp)%mod;
    }
}