class Solution {
    public int maxProfit(int[] prices) {
        int b=prices[0];
        int p=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<b){
                b=prices[i];
            }
            p = Math.max(p,prices[i]-b);
        }
        return p;
    }
}