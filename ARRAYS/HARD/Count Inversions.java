public class MergeSort {
    public static int mergeSort(int[] arr, int low, int high) {
        int c = 0;
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;

        // Divide array into 2 parts
        c += mergeSort(arr, low, mid);
        c += mergeSort(arr, mid + 1, high);

        // Merge and count inversions
        c += merge(arr, low, mid, high);
        return c;
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        int c = 0;

        // Compare and add to temp list
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                c += (mid - left + 1); // Count inversions
                right++;
            }
        }

        // Add remaining elements to list
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy sorted elements back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return c;
    }
}