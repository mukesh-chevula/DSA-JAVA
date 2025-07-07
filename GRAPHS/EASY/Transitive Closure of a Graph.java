// User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][]) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            res.add(new ArrayList<>());
            for(int j = 0; j < N; j++){
                if(i!=j) res.get(i).add(graph[i][j]);
                else res.get(i).add(1);
            }
        }
        
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(res.get(i).get(k) == 1 && res.get(k).get(j) == 1){
                        res.get(i).set(j, 1);
                    }
                }
            }
        }
        
        return res;
    }
}
