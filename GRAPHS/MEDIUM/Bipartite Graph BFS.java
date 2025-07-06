class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] colors=new int[n];

        for(int i=0;i<n;i++){
            if(colors[i]!=0){
                if(!bfs(graph,colors,i)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean bfs(int[][] graph, int[] colors, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        colors[node] = 1;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            for(int neighbor : graph[curr]){
                if(colors[neighbor] == 0){
                    colors[neighbor] = -colors[curr];
                    queue.offer(neighbor);
                } else if(colors[neighbor] == colors[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}