class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                fillOrder(adj, i, visited, stack);
            }
        }
        
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            transpose.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++) {
            for(Integer j : adj.get(i)) {
                transpose.get(j).add(i);
            }
        }
        
        Arrays.fill(visited, false);
        int scc = 0;
        
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if(!visited[node]) {
                dfs(transpose, node, visited);
                scc++;
            }
        }
        
        return scc;
    }
    
    private void fillOrder(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        
        for(Integer child : adj.get(node)) {
            if(!visited[child]) {
                fillOrder(adj, child, visited, stack);
            }
        }
        
        stack.push(node);
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        
        for(Integer child : adj.get(node)) {
            if(!visited[child]) {
                dfs(adj, child, visited);
            }
        }
    }
}