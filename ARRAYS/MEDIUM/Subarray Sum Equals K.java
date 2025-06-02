//leetcode 560

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int psum=0,c=0;
        for(int i:nums){
            psum+=i;
            if(map.containsKey(psum-k)){
                c+=map.get(psum-k);
            }
            map.put(psum, map.getOrDefault(psum, 0) + 1);
        }
        return c;
    }
}