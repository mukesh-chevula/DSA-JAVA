class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        for (int i=0;i<n;i++){
            capacity[i]-=rocks[i];
        }
        Arrays.sort(capacity);
        int res=0;
        for (int i=0;i<n;i++){
            if(capacity[i]==0) res++;
            else {
                additionalRocks-=capacity[i];
                if (additionalRocks >= 0) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}