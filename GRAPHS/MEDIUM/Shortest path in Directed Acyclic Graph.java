// User function Template for Java
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        Deque<Integer> st=new ArrayDeque<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj,st,visited,i);
            }
        }
        
        int[] dist=new int[V];
        Arrays.fill(dist,-1);
        dist[0]=0;
        
        while(!st.isEmpty()){
            int node=st.pop();
            int curDist=dist[node];
            if(curDist==-1) continue;
            List<int[]> children=adj.get(node);
            for(int[] child:children){
                if(dist[child[0]]!=-1){
                    dist[child[0]]=Math.min(dist[child[0]],curDist+child[1]);
                }else{
                    dist[child[0]]=curDist+child[1];
                }
            }
        }
        return dist;
    }
    void dfs(List<List<int[]>> adj,Deque<Integer> st,boolean[] visited,int node){
        visited[node]=true;
        
        for(int[] child:adj.get(node)){
            if(!visited[child[0]]){
                dfs(adj,st,visited,child[0]);
            }
        }
        
        st.push(node);
    }
}