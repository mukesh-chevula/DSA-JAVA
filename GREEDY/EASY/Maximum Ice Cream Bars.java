class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n=costs.length;
        Arrays.sort(costs);
        int index=0;
        int res=0;
        while(index<n && coins>=costs[index]){
            coins-=costs[index];
            index++;
            res++;
        }
        return res;
    }
}