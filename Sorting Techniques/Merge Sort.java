public class MergeSort(){
    public static void mergeSort(int[] arr,int low, int high){
        if(low>=high) return;
        int mid=low+(high-low)/2;
        
        //divide array into 2 parts
        mergeSort(arr,low,m);
        mergeSort(arr,mid+1,high);

        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left=low, right=mid+1;

        //compare and add to temp list
        while(left<=mid && right<=high){
            if(arr[left]>= arr[right]){
                temp.add(arr[right]);
                right++;
            }else{
                temp.add(arr[left]);
                left++;
            }
        }

        //add remaining elements to list
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }

        //copy temp array to original array
        for(int i=0;i<arr.length;i++){
            arr[i]=temp.get(i);
        }
    }
}

//TC O(nlogn)
//SC O(n) due to temp arr