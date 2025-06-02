static void bubbleSort(int[] arr,int n){
    for (int i = n - 1; i >= 0; i--) {//run backward to put max element at the end
        for (int j = 0; j <= i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                //compare adjacent elements and swap if necessary
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

//TC O(n^2)
//SC O(1)