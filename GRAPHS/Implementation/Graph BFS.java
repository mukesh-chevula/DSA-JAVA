class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited= new boolean[adj.size()];
        ArrayList<Integer> res=new ArrayList<>();
        q.add(0);
        while(!q.isEmpty()){
            int node=q.remove();
            if(visited[node]) continue;
            visited[node]=true;
            res.add(node);
            ArrayList<Integer> ch=adj.get(node);
            for(int i=0;i<ch.size();i++) if(visited[ch.get(i)]==false)q.add(ch.get(i));
        }
        return res;
    }
}