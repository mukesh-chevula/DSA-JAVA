//brute force

public class LargestElement {
    public static int bruteForce(int[] arr){
        //TC O(nlogn)
        //SC O(1)
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    public static int optimal(int[] arr){
        int max= arr[0];
        for (int i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            max= arr[i];
        }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        res= bruteForce(arr);

        res= optimal(arr);

        System.out.println("Max Element:" + res);
    }
}
