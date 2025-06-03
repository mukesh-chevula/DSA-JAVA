public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    public static int mergeSort(int[] arr, int low, int high, int[] temp) {
        int c = 0;
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;

        // Divide array into 2 parts
        c += mergeSort(arr, low, mid, temp);
        c += mergeSort(arr, mid + 1, high, temp);

        // Merge and count pairs
        c += merge(arr, low, mid, high, temp);
        return c;
    }

    public static int merge(int[] arr, int low, int mid, int high, int[] temp) {
        int c = 0;
        int right = mid + 1;

        // Count reverse pairs
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right]) {
                right++;
            }
            c += (right - (mid + 1));
        }

        // Merge two sorted halves
        int left = low, r = mid + 1, t = low;
        while (left <= mid && r <= high) {
            if (arr[left] <= arr[r]) {
                temp[t++] = arr[left++];
            } else {
                temp[t++] = arr[r++];
            }
        }

        while (left <= mid) {
            temp[t++] = arr[left++];
        }

        while (r <= high) {
            temp[t++] = arr[r++];
        }

        // Copy back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }

        return c;
    }
}
