class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Process borders in a single loop
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int row, int col) {
        ocean[row][col] = true;
        
        for (int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValid(newRow, newCol, heights.length, heights[0].length) &&
                !ocean[newRow][newCol] &&
                heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, ocean, newRow, newCol);
            }
        }
    }

    private boolean isValid(int row, int col, int maxRow, int maxCol) {
        return row >= 0 && col >= 0 && row < maxRow && col < maxCol;
    }
}
