class Solution {
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;

        int s = n * (n + 1) / 2;
        int s2 = n * (n + 1) * (2 * n + 1) / 6;

        int sum = 0;
        int sum2 = 0;

        for (int i : nums) {
            sum += i;
            sum2 += i * i;
        }

        int diff = sum - s; // x - y
        int diff2 = sum2 - s2; // x^2 - y^2

        // x + y
        int sumXY = diff2 / diff;

        int x = (sumXY + diff) / 2;
        int y = (sumXY - diff) / 2;

        return new int[]{x, y};
    }

    public static int[] findMissingRepeatingNumbersXOR(int[] nums) {
        int xor = 0;
        int n = nums.length;

        // XOR all array elements and numbers from 1 to n
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
            xor ^= (i + 1);
        }

        // Find the rightmost set bit
        int setBit = xor & -xor;

        int x = 0, y = 0;

        // Divide elements into two groups based on the set bit
        for (int i = 0; i < n; i++) {
            if ((nums[i] & setBit) != 0) {
                x ^= nums[i];
            } else {
                y ^= nums[i];
            }

            if (((i + 1) & setBit) != 0) {
                x ^= (i + 1);
            } else {
                y ^= (i + 1);
            }
        }

        // Determine which is missing and which is repeating
        for (int num : nums) {
            if (num == x) {
                return new int[]{x, y}; // x is repeating, y is missing
            }
        }
        return new int[]{y, x}; // y is repeating, x is missing
    }
}
