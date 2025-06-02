//leetcode 118
class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            long ans = 1;
            List<Integer> ansRow = new ArrayList<>();
            ansRow.add(1); 

            for (int col = 1; col < row; col++) {
                ans = ans * (row - col);
                ans = ans / col;
                ansRow.add((int)ans);
            }
            res.add(ansRow);
        }
        return res;
    }
}