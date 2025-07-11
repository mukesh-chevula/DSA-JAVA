class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], n * n);
        dist[0][0] = grid[0][0];
        TreeSet<int[]> set = new TreeSet<>(
                (a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        set.add(new int[] { 0, 0, grid[0][0] });
        while (!set.isEmpty()) {
            int[] p = set.pollFirst();
            int i = p[0], j = p[1], time = p[2];
            if (i == n - 1 && j == n - 1)
                break;
            for (int[] d : dir) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= n || y < 0 || y >= n)
                    continue;
                int alt = time + Math.max(0, grid[x][y] - time);
                if (alt < dist[x][y]) {
                    int[] key = { x, y, dist[x][y] };
                    set.remove(key);
                    key[2] = dist[x][y] = alt;
                    set.add(key);
                }
            }
        }
        return dist[n - 1][n - 1];
    }
}