class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1,n,k,res,new ArrayList<>());
        return res;
    }
    public void helper(int index,int target, int k,List<List<Integer>> res, List<Integer> ds){
        if(target<0) return;

        if(target==0 && ds.size()==k){
            res.add(new ArrayList(ds));
            return;
        }

        if(ds.size()>k) return;

        for(int i=index;i<=9;i++){
            ds.add(i);
            helper(i+1,target-i,k,res,ds);
            ds.remove(ds.size()-1);
        }
    }
}