public class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n=maze.length;
        ArrayList<String> res = new ArrayList<>();
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) return res;
        boolean[][] visited = new boolean[n][n];
        solve(0, 0, maze, n, "", visited, res);
        Collections.sort(res);
        return res;
    }

    private static void solve(int curx, int cury, int[][] maze, int n, String path, boolean[][] visited, ArrayList<String> res) {
        if (curx == n - 1 && cury == n - 1) {
            res.add(path);
            return;
        }

        visited[curx][cury] = true;

        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        String dir= new String("DLRU");

        for (int k = 0; k < 4; k++) {
            int newx = curx + di[k];
            int newy = cury + dj[k];

            if (newx >= 0 && newx < n && newy >= 0 && newy < n && maze[newx][newy] == 1 && !visited[newx][newy]) {
                solve(newx, newy, maze, n, path + dir.charAt(k), visited, res);
            }
        }

        visited[curx][cury] = false;
    }
}