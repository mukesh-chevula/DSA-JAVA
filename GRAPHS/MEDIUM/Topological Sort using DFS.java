class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        Deque<Integer> st=new ArrayDeque<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]) dfs(i,adj,st,visited);
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
    }
    static void dfs(int node,List<List<Integer>> adj,Deque<Integer> st,boolean[] visited){
        visited[node]=true;
        
        for(Integer neighbor:adj.get(node)){
            if(!visited[neighbor]) dfs(neighbor,adj,st,visited);
        }
        st.push(node);
    }
}