class Solution {
    private boolean calc(int[] bloomDay,int m,int k,int days) {
        int bouquets=0;
        int flowers=0;

        for(int bloom:bloomDay) {
            if (bloom<=days) {
                flowers++;
                if (flowers==k) {
                    bouquets++;
                    flowers=0;
                }
            }else flowers=0;
            
            if(bouquets>=m) return true;
        }

        return false;
    }
    public int minDays(int[] bloomDay,int m,int k) {
        int n=bloomDay.length;
        if((long)m*k >(long)n){
            return -1;
        }

        int max=0,min=Integer.MAX_VALUE;
        for(int i:bloomDay){
            max=Math.max(i,max);
            min=Math.min(i,min);
        }

        int low=min,high=max,res=max,mid;
        while (low <= high) {
            mid=low+(high-low)/2;
            if (calc(bloomDay,m,k,mid)) {
                res=mid;
                high=mid - 1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
}