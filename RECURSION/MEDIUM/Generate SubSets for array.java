class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        _subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private static void _subsets(int[] nums, int index, List<Integer> curSet, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(curSet));
            return;
        }

        curSet.add(nums[index]);
        _subsets(nums, index + 1, curSet, result);
        
        curSet.remove(curSet.size()-1);
        _subsets(nums, index + 1, curSet, result);
    }
}