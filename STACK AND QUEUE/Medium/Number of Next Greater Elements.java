import java.util.*;

public class NumberOfGreaterElementsToRight {
    public static int[] countGreaterElementsToRight(int[] arr, int[] indices) {
        int n = arr.length;
        int q = indices.length;
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int index = indices[i];
            int count = 0;
            for (int j = index + 1; j < n; j++) {
                if (arr[j] > arr[index]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices = {0, 5};
        int[] result = countGreaterElementsToRight(arr, indices);
        System.out.println("Count of Greater Elements to the Right: " + Arrays.toString(result));

        int[] arr2 = {1, 2, 3, 4, 1};
        int[] indices2 = {0, 3};
        int[] result2 = countGreaterElementsToRight(arr2, indices2);
        System.out.println("Count of Greater Elements to the Right: " + Arrays.toString(result2));
    }
}