public static void quickSort(int[] arr, int low, int high){
    if(low<high){
        int pIndex= partition(arr,low,high);
        quickSort(arr,low,pIndex);
        quickSort(arr,pIndex+1,high);
    }
}

public static int partition(int[] arr, int low, int high){
    int pivot=arr[low];
    int left=low;
    int right=high;

    while(left<right){
        while(arr[left]<=pivot && left<=high-1) left++;

        while(arr[right]>pivot && right>=low+1) right++;

        if(left<right) swap(arr,left,right);
    }
    swap(arr,low,right);
    return right;
}
public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}


//TC O(nlogn)
//SC O(1)+O(n){Auxillary stack space}