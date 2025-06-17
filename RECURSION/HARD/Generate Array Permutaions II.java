class Solution{
    public List<List<Integer>> permuteUnique(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        helper(arr, 0, res);
        return res;
    }

    private void helper(int[] arr, int index, List<List<Integer>> res) {
        if (index == arr.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : arr) {
                currentPermutation.add(num);
            }
            res.add(currentPermutation);
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if(visited.contains(arr[i])) continue;
            visited.add(arr[i]);

            swap(arr, i, index);
            helper(arr, index + 1, res);
            swap(arr, i, index);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}