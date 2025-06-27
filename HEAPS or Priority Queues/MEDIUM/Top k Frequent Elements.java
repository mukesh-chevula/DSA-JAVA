class Solution {
    static{
        for(int i=0;i<=300;i++) topKFrequent(new int[0],0);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll().getKey();
        }
        return ans;
    }
}