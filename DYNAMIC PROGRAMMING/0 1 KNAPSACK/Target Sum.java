import java.util.Arrays;

/**
 * Solution class for the Target Sum problem.
 * Contains two methods:
 * 1. findTargetSumWaysNaive: Naive recursive + memoization approach.
 * 2. findTargetSumWaysBest: Optimized DP approach using subset sum transformation.
 */
class Solution {

    /**
     * Naive recursive approach with memoization to find the number of ways to assign
     * '+' and '-' to make the sum equal to target.
     *
     * @param nums   Array of integers.
     * @param target Target sum to achieve.
     * @return Number of ways to achieve target sum.
     */
    public int findTargetSumWaysNaive(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        // Calculate total sum of elements for offsetting negative indices
        for (int i : nums)
            sum += i;
        // DP table: dp[shiftedSum][index]
        int[][] dp = new int[2 * sum + 1][n + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        // Start recursive helper with initial cursum = 0 and index = 0
        return helperNaive(nums, target, 0, 0, dp, sum);
    }

    /**
     * Helper function for naive approach.
     *
     * @param nums    Array of integers.
     * @param target  Target sum.
     * @param cursum  Current sum.
     * @param index   Current index in nums.
     * @param dp      Memoization table.
     * @param offset  Offset to handle negative sums.
     * @return Number of ways to achieve target sum from current state.
     */
    private int helperNaive(int[] nums, int target, int cursum, int index, int[][] dp, int offset) {
        // Base case: all elements processed
        if (index >= nums.length) {
            return cursum == target ? 1 : 0;
        }

        // Shifted index to handle negative sums
        int shifted = cursum + offset;

        // Return memoized result if available
        if (dp[shifted][index] != -1)
            return dp[shifted][index];

        // Try adding and subtracting current number
        int add = helperNaive(nums, target, cursum + nums[index], index + 1, dp, offset);
        int subtract = helperNaive(nums, target, cursum - nums[index], index + 1, dp, offset);

        // Memoize and return result
        return dp[shifted][index] = add + subtract;
    }

    /**
     * Optimized DP approach using subset sum transformation.
     * Converts the problem to finding subsets with sum s1 = (d + sum(nums)) / 2.
     *
     * @param nums Array of integers.
     * @param d    Target difference.
     * @return Number of ways to achieve target sum.
     */
    int findTargetSumWaysBest(int[] nums, int d) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) sum += i;

        // Check if (d + sum) is even and s1 is valid
        if ((d + sum) % 2 != 0) return 0;
        int s1 = (d + sum) / 2;
        if (s1 < 0 || s1 > sum) return 0;

        // DP table: dp[index][remainingSum]
        int[][] dp = new int[n][s1 + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Start recursive helper
        return helperBest(nums, s1, 0, dp);
    }

    /**
     * Helper function for optimized approach.
     *
     * @param nums     Array of integers.
     * @param remaining Remaining sum to achieve.
     * @param index    Current index in nums.
     * @param dp       Memoization table.
     * @return Number of ways to achieve remaining sum from current state.
     */
    private int helperBest(int[] nums, int remaining, int index, int[][] dp) {
        // Base case: all elements processed
        if (index == nums.length) return remaining == 0 ? 1 : 0;
        if (remaining < 0) return 0;

        // Return memoized result if available
        if (dp[index][remaining] != -1) return dp[index][remaining];

        // Include current number in subset
        int include = helperBest(nums, remaining - nums[index], index + 1, dp);
        // Exclude current number from subset
        int exclude = helperBest(nums, remaining, index + 1, dp);

        // Memoize and return result
        return dp[index][remaining] = include + exclude;
    }
}