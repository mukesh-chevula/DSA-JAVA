
class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src,0});
        int[] dist=new int[adj.size()];
        Arrays.fill(dist,-1);
        dist[src]=0;
        while(!q.isEmpty()){
            int[] pair=q.poll();
            int node=pair[0];
            int curDist=pair[1];
            for(Integer child:adj.get(node)){
                if(dist[child]==-1){
                    dist[child]=curDist+1;
                    q.offer(new int[]{child,dist[child]});
                }
            }
        }
        return dist;
    }
}
