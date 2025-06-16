public class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n=maze.length;
        List<String> res = new ArrayList<>();
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return res;
        }
        boolean[][] visited = new boolean[n][n];
        solve(0, 0, maze, n, "", visited, res);
        Collections.sort(res);
        return res;
    }

    private static void solve(int curx, int cury, int[][] maze, int n, String path, boolean[][] visited, List<String> res) {
        if (curx == n - 1 && cury == n - 1) {
            res.add(path);
            return;
        }

        visited[curx][cury] = true;

        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        for (int k = 0; k < 4; k++) {
            int newx = curx + di[k];
            int newy = cury + dj[k];

            if (isSafe(newx, newy, maze, n, visited)) {
                solve(newx, newy, maze, n, path + dir[k], visited, res);
            }
        }

        visited[curx][cury] = false;
    }

    private static boolean isSafe(int curx, int cury, int[][] maze, int n, boolean[][] visited) {
        return curx >= 0 && curx < n && cury >= 0 && cury < n && maze[curx][cury] == 1 && !visited[curx][cury];
    }
}