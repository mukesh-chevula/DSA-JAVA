class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0,max_c=0;
        for(int i:nums){
            if(i==1){ 
                c++;
                max_c=Math.max(c,max_c);
            }
            else c=0;
        }
        return max_c;
    }
}