class Solution{
        public List<List<Integer>> generateArrayPermutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        generateArrayPermutationsHelper(arr, 0, result);
        return result;
    }

    private void generateArrayPermutationsHelper(int[] arr, int index, List<List<Integer>> result) {
        if (index == arr.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : arr) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            generateArrayPermutationsHelper(arr, index + 1, result);
            swap(arr, i, index);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}