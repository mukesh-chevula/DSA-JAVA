class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1,n,k,res, new ArrayList<>());
        return res;
    }
    public void helper(int index, int n, int k, List<List<Integer>> res, List<Integer> ds){
        if(ds.size()==k){
            res.add(new ArrayList(ds));
            return;
        }
        
        if(ds.size()>k) return;

        for(int i=index;i<=n;i++){
            ds.add(i);
            helper(i+1,n,k,res,ds);
            ds.remove(ds.size()-1);
        }
    }
}