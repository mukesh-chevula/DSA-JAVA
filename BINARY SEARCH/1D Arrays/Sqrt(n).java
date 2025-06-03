class Solution {
    public int mySqrt(int x) {
        int low=1, high=x,mid,sq;

        while(low<=high){
            mid=low+(high-low)/2;
            sq=x/mid;
            if(sq==mid) return mid;
            else if(sq<mid) high=mid-1;
            else low=mid+1;
        }
        return high;
    }
}

//nth root

public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    public static int NthRoot(int n, int m) {
        // Use binary search on the answer space:
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }