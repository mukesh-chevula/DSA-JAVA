class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res= new ArrayList<Integer>();
        boolean[] visited = new boolean[adj.size()];
        Deque<Integer> st=new ArrayDeque<>();
        st.addFirst(0);
        while(!st.isEmpty()){
            int node=st.removeFirst();
            if (visited[node]) continue;
            res.add(node);
            visited[node]=true;
            ArrayList<Integer> ch=adj.get(node);
            for(int i=ch.size()-1;i>=0;i--){
                if(!visited[ch.get(i)]) st.addFirst(ch.get(i));
            }
        }
        return res;
    }
}