class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, graph.length - 1, path, res);
        return res;
    }
    
    private void dfs(int[][] graph, int node, int target, List<Integer> path, List<List<Integer>> res) {
        if (node == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for (int neighbor : graph[node]) {
            path.add(neighbor);
            dfs(graph, neighbor, target, path, res);
            path.remove(path.size() - 1); 
        }
    }
}
