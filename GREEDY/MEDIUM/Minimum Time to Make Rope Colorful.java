class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int res=0,j=0;
        for(int i=0;i<n-1;i=j){
            int currTotal = 0, currMax = 0; 
            while (j < n && colors.charAt(i) == colors.charAt(j)) {
                currTotal += neededTime[j]; 
                currMax = Math.max(currMax, neededTime[j]); 
                j++;
            }
            res+=currTotal-currMax;
        }
        return res;
    }
}