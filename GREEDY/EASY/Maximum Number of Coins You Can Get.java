class Solution {
    public int maxCoins(int[] piles) {
        int n=piles.length;
        Arrays.sort(piles);
        int my=n-2,bob=0;
        int res=0;
        while(my>bob){
            res+=piles[my];
            my-=2;
            bob++;
        }
        return res;
    }
}
