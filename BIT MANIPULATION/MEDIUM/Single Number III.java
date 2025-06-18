class Solution {
    public int[] singleNumber(int[] nums) {
        int x=0;
        for(int i:nums) x^=i;

        x = x & -x;

        int b0=0;
        int b1=0;

        for(int i:nums){
            if((i&x)!=0) b0^=i;
            else b1^=i;
        }

        return new int[]{b0,b1};
    }
}