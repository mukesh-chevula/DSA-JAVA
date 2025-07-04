class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length,n=image[0].length;
        boolean[][] visited=new boolean[m][n];
        int match=image[sr][sc];
        dfs(image,visited,sr,sc,color,match);
        return image;
    }
    void dfs(int[][] image, boolean[][] visited, int i, int j,int color,int match){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j]!=match || visited[i][j]) return;

        visited[i][j]=true;
        image[i][j]=color;

        dfs(image,visited,i+1,j,color,match);
        dfs(image,visited,i-1,j,color,match);
        dfs(image,visited,i,j+1,color,match);
        dfs(image,visited,i,j-1,color,match);
    }
}