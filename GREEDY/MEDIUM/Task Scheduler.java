class Solution {
    public int leastInterval(char[] tasks, int n) {
       int freq[]= new int[26];
       for(char c:tasks){
        freq[c-'A']++;
       }
       int maxFreq=0,maxFreqCount=0;
       for(int f:freq){
            if(f>maxFreq){
                maxFreq=f;
                maxFreqCount=1;
            }else if(f==maxFreq)    maxFreqCount++;
       }
       int time=(maxFreq-1)*(n+1)+maxFreqCount;
       return Math.max(tasks.length,time);
    }
}