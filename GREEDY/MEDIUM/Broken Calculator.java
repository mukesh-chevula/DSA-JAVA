class Solution {
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while(target > startValue) {
            if((target&1)==0 ){
                target>>=1;
            } else {
                target++;
            }
            count++;
        }
        count += (startValue - target);
        return count;
    }
}