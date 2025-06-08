class Solution {
    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            cnt += Math.ceil((arr[i] - arr[i - 1]) / dist) - 1;
        }
        return cnt;
    }

    public static double findSmallestMaxDist(int[] arr, int k) {
        double low = 0, high = 0;

        for (int i = 1; i < arr.length; i++) {
            high = Math.max(high, arr[i] - arr[i - 1]);
        }

        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            if (numberOfGasStationsRequired(mid, arr) > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
