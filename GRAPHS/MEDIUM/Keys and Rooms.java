class Solution {
    public static void DFS(List<List<Integer>> graph, int curr, boolean visited[]){
        visited[curr]=true;
        for(int i=0;i<graph.get(curr).size();i++){ 
            if(!visited[graph.get(curr).get(i)]){
                DFS(graph,graph.get(curr).get(i),visited);
            }
        }
        
        
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        DFS(rooms,0,visited);

        for(boolean x : visited){
            if(!x) return x;
        }
        return true;
    }
}