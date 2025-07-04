class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] count=new int[n];
        for(List<Integer> edge:edges){
            count[edge.get(1)]++;
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(count[i]==0) res.add(i);
        }
        return res;
    }
}