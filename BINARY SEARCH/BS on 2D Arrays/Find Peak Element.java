class Solution {
    public int[] findPeakGrid(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = 0;

        while (true) {
            int maxRow = row, maxCol = col;
            
            if (row > 0 && matrix[row - 1][col] > matrix[maxRow][maxCol]) maxRow = row - 1;
            if (row < m - 1 && matrix[row + 1][col] > matrix[maxRow][maxCol]) maxRow = row + 1;
            if (col > 0 && matrix[row][col - 1] > matrix[maxRow][maxCol]) maxCol = col - 1;
            if (col < n - 1 && matrix[row][col + 1] > matrix[maxRow][maxCol]) maxCol = col + 1;

            if (maxRow == row && maxCol == col) return new int[]{row, col};

            row = maxRow;
            col = maxCol;
        }
    }
}
