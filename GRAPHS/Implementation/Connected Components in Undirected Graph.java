
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] i:edges){
            int u=i[0],v=i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                ArrayList<Integer> temp= traverse(i,visited,adj);
                res.add(temp);
            }
        }
        return res;
    }
    ArrayList<Integer> traverse(int node,boolean[] visited,List<List<Integer>> adj){
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int cur=q.remove();
            if(visited[cur]) continue;
            visited[cur]=true;
            res.add(cur);
            for (int i = 0; i < adj.get(cur).size(); i++) 
                if (!visited[adj.get(cur).get(i)]) 
                    q.add(adj.get(cur).get(i));
        }
        return res;
    }
}