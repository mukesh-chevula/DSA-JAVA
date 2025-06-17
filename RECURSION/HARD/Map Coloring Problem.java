class Solution {
    boolean graphColoring(int V,int[][] edges,int m) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] colors=new int[V];
        for(int i=0;i<V;i++) {
            colors[i]=0;
        }

        return canColorGraph(0,adj,colors,m,V);
    }

    private boolean canColorGraph(int node,List<List<Integer>> adj,int[] colors,int m,int V) {
        if(node==V) {
            return true;
        }

        for(int color=1;color<=m;color++) {
            if(isSafeToColor(node,adj,colors,color)) {
                colors[node]=color; 
                if(canColorGraph(node+1,adj,colors,m,V)) {
                    return true; 
                }
                colors[node]=0;
            }
        }

        return false; 
    }

    private boolean isSafeToColor(int node,List<List<Integer>> adj,int[] colors,int color) {
        for(int neighbor:adj.get(node)) {
            if(colors[neighbor]==color) {
                return false;
            }
        }
        return true;
    }
}
