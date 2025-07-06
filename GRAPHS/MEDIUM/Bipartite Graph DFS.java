class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] colors=new int[n];

        for(int i=0;i<n;i++){
            if(colors[i]==0){
                if(!dfs(graph,colors,i,1)) return false;
            }
        }
        return true;
    }
    boolean dfs(int[][] graph, int[] colors, int node,int color){
        if(colors[node]!=0) return colors[node] == color;
        colors[node]=color;
        for(int i:graph[node]){
            if(colors[i] == 0){
                if(!dfs(graph, colors, i, color * -1)) return false;
            } else if(colors[i] == colors[node]){
                return false;
            }
        }
        return true;
    }
}