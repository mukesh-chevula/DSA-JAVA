class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new double[]{(double)edges[i][1],succProb[i]});
            adj.get(edges[i][1]).add(new double[]{(double)edges[i][0],succProb[i]});
        }
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        double[] prob=new double[n];
        Arrays.fill(prob,0.0);
        prob[start_node]=1.0;
        pq.offer(new double[]{1.0,start_node});

        while(!pq.isEmpty()){
            double[] cur=pq.poll();
            double curprob=cur[0];
            int node=(int)cur[1];
            if(curprob<prob[node]) continue;
            if(node==end_node) return curprob;
            for(double[] ch :adj.get(node)){
                int child=(int)ch[0];
                double p=ch[1];
                double nprob=curprob*p;
                if(nprob>prob[child]){
                    prob[child] = nprob; 
                    pq.offer(new double[]{nprob,(double)child});
                }
            }
        }
        return 0.0;
    }
}