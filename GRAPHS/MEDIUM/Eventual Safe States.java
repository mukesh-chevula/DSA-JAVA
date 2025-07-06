class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseAdj = new ArrayList<>();
        int[] indegree = new int[n];
        
        for(int i = 0; i < n; i++) {
            reverseAdj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++) {
            for(int neighbor : graph[i]) {
                reverseAdj.get(neighbor).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        boolean[] safe = new boolean[n];
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;
            
            for(int predecessor : reverseAdj.get(node)) {
                indegree[predecessor]--;
                if(indegree[predecessor] == 0) {
                    queue.offer(predecessor);
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(safe[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}
