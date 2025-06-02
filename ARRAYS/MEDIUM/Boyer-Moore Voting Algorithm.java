class Solution {
    public int majorityElement(int[] nums) {
        int ele=nums[0];
        int count=0;
        for(int i:nums){
            if(i==ele) count++;
            else count--;
            if(count<1){
                ele=i;
                count=1;
            }
        }
        return ele;
    }
}