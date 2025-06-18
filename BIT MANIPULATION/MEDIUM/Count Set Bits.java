// User function Template for Java
class Solution {
    public static int countSetBits(int n) {
        // Your code here
        int c=0;
        while(n>1){
            c+=n&1;
            n=n>>1;
        }
        if(n==1) c++;
        return c;
    }
    public static int countSetBits(int n) {
        int c=0;
        while(n!-0){
            c++;
            n=(n&(n-1));
        }
        return c;
    }
}