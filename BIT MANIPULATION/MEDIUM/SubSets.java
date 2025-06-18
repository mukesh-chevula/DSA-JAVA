class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n=1<<nums.length;

        for(int num=0;num<n;num++){
            List<Integer> temp=new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((num & (1 << i)) != 0)
                    temp.add(nums[i]);
            }
            res.add(temp);
        }
        return res;
    }
}