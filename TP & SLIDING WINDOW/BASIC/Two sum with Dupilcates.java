class Solution {
    int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                //allow duplicates
                if (arr[left] == arr[right]) {
                    int n = right - left + 1;
                    count += (n * (n - 1)) / 2;
                    break;
                }

                int countLeft = 1, countRight = 1;
                while (left + 1 < right && arr[left] == arr[left + 1]) {
                    countLeft++;
                    left++;
                }

                while (right - 1 > left && arr[right] == arr[right - 1]) {
                    countRight++;
                    right--;
                }

                count += countLeft * countRight;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
