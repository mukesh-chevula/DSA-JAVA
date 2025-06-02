public class IsSorted {
    public boolean isSorted(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        res= IsSorted(arr);

        System.out.println("Max Element:" + res);
    }
}
