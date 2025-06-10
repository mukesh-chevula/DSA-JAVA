class Solution {
    public static double findMedianSortedArrays(int[] a,int[] b) {
        int n1=a.length,n2=b.length;
        // Ensure that the first array is the smaller one to minimize binary search range
        if (n1>n2) return findMedianSortedArrays(b,a);

        int left=(n1+n2+1)/2; // Calculate the number of elements in the left partition
        int low=0,high=n1; // Binary search range for the smaller array

        while (low<=high) {
            int mid1=(low+high)/2; // Partition index for the first array
            int mid2=left-mid1; // Partition index for the second array

            // Get the left and right elements around the partition for both arrays
            int l1=(mid1>0)?a[mid1-1]:Integer.MIN_VALUE; // Left of partition in array a
            int r1=(mid1<n1)?a[mid1]:Integer.MAX_VALUE; // Right of partition in array a
            int l2=(mid2>0)?b[mid2-1]:Integer.MIN_VALUE; // Left of partition in array b
            int r2=(mid2<n2)?b[mid2]:Integer.MAX_VALUE; // Right of partition in array b

            // Check if the partitions are valid
            if (l1<=r2&&l2<=r1) {
                // If total number of elements is odd, return the max of left partition
                if ((n1+n2)%2==1) return Math.max(l1,l2);
                // If total number of elements is even, return the average of max of left and min of right
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            } else if (l1>r2) {
                // If l1 is greater than r2, move the partition in array a to the left
                high=mid1-1;
            } else {
                // If l2 is greater than r1, move the partition in array a to the right
                low=mid1+1;
            }
        }
        return 0; // This line should never be reached if inputs are valid
    }
}
