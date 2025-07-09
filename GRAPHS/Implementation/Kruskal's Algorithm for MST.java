// User function Template for Java
class Solution {
    private static class DisjointSetUnion {
        private int[] parent;
        private int[] size;
        private int n;
    
        public DisjointSetUnion(int n) {
            this.n = n;
            parent = new int[n];
            size = new int[n];
    
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
    
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
    
            if (rootX == rootY) {
                return;
            }
    
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }
    static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        
        DisjointSetUnion dsu = new DisjointSetUnion(V);
        
        int mstCost = 0;
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                mstCost += wt;
            }
        }
        
        return mstCost;
    }

}
