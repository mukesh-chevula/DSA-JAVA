class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum=0,rSum=0,maxSum=0,n=cardPoints.length;
        for(int i=0;i<k;i++){
            lSum+=cardPoints[i];
        }
        maxSum=lSum;

        for (int i = 0; i < k; i++) {
            lSum -= cardPoints[k - 1 - i];
            rSum += cardPoints[n - 1 - i];
            maxSum = Math.max(maxSum, lSum + rSum);
        }

        return maxSum;
    }
}