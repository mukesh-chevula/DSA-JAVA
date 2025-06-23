class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int small=0,large=tokens.length-1;
        int score=0,maxScore=0;

        while(small<=large){
            if(tokens[small]<=power){
                score+=1;
                maxScore=Math.max(score,maxScore);
                power-=tokens[small];
                small++;
            }else if(score>=1){
                power+=tokens[large];
                large--;
                score--;
            }else{
                break;
            }
        }
        return maxScore;
    }
}