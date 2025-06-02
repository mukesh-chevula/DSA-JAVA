static void selection_sort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int mini = i;
        for (int j = i + 1; j < n; j++) {
            //Search for min in rest of array
            if (arr[j] < arr[mini]) {
                mini = j;
            }
        }
        //swap with minimum element
        int temp = arr[mini];
        arr[mini] = arr[i];
        arr[i] = temp;
    }
    
}

//TC O(n^2)
//SC O(1)