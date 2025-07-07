class Solution {
    public int nearestExit(char[][] maze, int[] entry) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        q.offer(new int[]{entry[0], entry[1], 0});
        visited[entry[0]][entry[1]] = true;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1], steps = cur[2];
            
            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1) && 
                !(row == entry[0] && col == entry[1])) {
                return steps;
            }
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    maze[newRow][newCol] == '.' && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    q.offer(new int[]{newRow, newCol, steps + 1});
                }
            }
        }
        
        return -1;
    }
}
