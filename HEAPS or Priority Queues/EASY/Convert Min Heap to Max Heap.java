class Solution {
    static void convertMinToMaxHeap(int N, int arr[]) {
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
        }
    }

    static void heapify(int[] arr, int N, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < N && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < N && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, N, largest);
        }
    }
}
