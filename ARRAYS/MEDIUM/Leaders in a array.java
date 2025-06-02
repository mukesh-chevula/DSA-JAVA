class Solution {
    public ArrayList<Integer> leaders(int[] nums) {
        int max = nums[nums.length-1];
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>=max){
                res.add(nums[i]);
                max=nums[i];
            }
        }
        return Collections.reverse(res);
    }
}