class Solution{
    static int xorN(int n){
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        if(n%4==3) return 0;
        if(n%4==0) return n;
    }
    public static int xorLR(int l, int r){
        return xorN(l-1)^xorN(r);
    }
}