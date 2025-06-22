class Solution {
    public int removeDuplicates(int[] arr) {
        int left = 0;
        for (int right = 1; right < arr.length; right++) {
            if (arr[left] != arr[right]) {
                left++;
                arr[left] = arr[right];
            }
        }
        return left + 1;
    }
}