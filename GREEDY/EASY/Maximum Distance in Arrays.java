class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int max=arrays.get(0).get(arrays.get(0).size()-1),min=arrays.get(0).get(0),maxDiff=0;
        for(int i=1;i<arrays.size();i++){
            List<Integer> list=arrays.get(i);
            maxDiff=Math.max(maxDiff,Math.abs(list.get(list.size()-1)-min));
            maxDiff=Math.max(maxDiff,Math.abs(list.get(0)-max));
            min=Math.min(min,list.get(0));
            max=Math.max(max,list.get(list.size()-1));
        }
        return maxDiff;
    }
}
