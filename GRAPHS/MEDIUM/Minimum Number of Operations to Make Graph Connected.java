class Solution {
    public class DSU {
        private int[] parent;
        private int[] size;
        private int n;

        public DSU(int n) {
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

        public boolean areConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int countSets() {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (parent[i] == i) {
                    count++;
                }
            }
            return count;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(n-1>connections.length) return -1;
        DSU dsu=new DSU(n);
        for(int[] edge :connections) dsu.union(edge[0],edge[1]);

        return dsu.countSets()-1;
    }
}