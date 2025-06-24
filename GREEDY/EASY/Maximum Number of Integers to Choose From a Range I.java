class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int res=0,sum=0;
        int[] hash=new int[10001];
        for(int i=0; i<banned.length; i++){
            hash[banned[i]]=1;
        }
        for(int i=1;i<=n;i++){
            if(hash[i]!=1 ) {
                if(sum+i <=maxSum){
                    sum+=i;
                    res++;
                }else break;
            }
        }
        return res;
    }
}