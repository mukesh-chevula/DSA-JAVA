class Solution{
    public int countZeroes(int num){
        return rec(num,0);
    }
    public int rec(int num, int c){
        if(num<0) return 0;
        if(num%10==0) c++;
        return rec(num/10, c);
    }
}