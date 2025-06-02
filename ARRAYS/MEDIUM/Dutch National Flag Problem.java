class Solution {
    public void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
    public void sortColors(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
    
        while (mid <= high) {
            if      (arr[mid] == 0) { swap(arr, low++, mid++); }
            else if (arr[mid] == 2) { swap(arr, mid, high--); }
            else if (arr[mid] == 1) { mid++; }
        }
        
    }
}