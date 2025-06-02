//leetcide 56

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (res.isEmpty() || intervals[i][0] > res.get(res.size() - 1).get(1)) {
                res.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
            }
            else {
                res.get(res.size() - 1).set(1,Math.max(res.get(res.size() - 1).get(1), intervals[i][1]));
            }
        }
        int[][] array = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> row = res.get(i);
            array[i][0] = row.get(0); 
            array[i][1] = row.get(1);
        }


        return array;
    }
}