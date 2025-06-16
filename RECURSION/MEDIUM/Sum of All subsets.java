public class Solution {
    public static void SumOfAllSubsets(int[] nums) {
        List<Integer> result = new ArrayList<>();
        calculateSubsetSums(nums, 0, 0, result);
    }
    private static void calculateSubsetSums(int[] nums, int index, int currentSum, List<Integer> result) {
        if (index == nums.length) {
            result.add(currentSum);
            return;
        }
        calculateSubsetSums(nums, index + 1, currentSum + nums[index], result);

        calculateSubsetSums(nums, index + 1, currentSum, result);
    }
}