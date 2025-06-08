class Solution {
    static {
        for (int i = 0; i < 300; i++) shipWithinDays(new int[0], 1);
    }
    private static boolean canShip(int[] weights,int days,int capacity){
        int dayCount=1,currentLoad=0;
        for(int weight:weights){
            if(currentLoad+weight>capacity){
                dayCount++;
                currentLoad=weight;
                if(dayCount>days)return false;
            }else{
                currentLoad+=weight;
            }
        }
        return true;
    }
    public static int shipWithinDays(int[] weights,int days){
        int low=0,high=0;
        for (int weight : weights) {
            low = Math.max(low, weight); 
            high += weight; 
        }
        
        int res = high;
        for(int weight:weights)high+=weight;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canShip(weights,days,mid)){
                res=Math.min(res,mid);
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
}
