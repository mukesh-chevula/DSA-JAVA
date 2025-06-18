class Solution {
    public int minBitFlips(int start, int goal) {
        goal=start^goal;

        int c=0;
        while(goal!=0){
            c++;
            goal=(goal&(goal-1));
        }
        return c;
    }
}