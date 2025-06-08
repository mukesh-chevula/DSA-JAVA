class Solution {
    public int calc(int[]piles,int r){
        int res=0;
        for(int i:piles){
            res += Math.ceil((double)(i) / (double)(r));
        }
        return res;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i:piles) max=Math.max(max,i);

        int low=0,high=max,res=max,mid,time;
        while(low<=high){
            mid=(low+high)/2;
            time = calc(piles,mid);

            if(time<=h){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return res;
    }
}