class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        StringBuilder res=new StringBuilder();
        while(!pq.isEmpty()){
            char c = pq.poll();
            res.append(String.valueOf(c).repeat(map.get(c)));
        }
        return res.toString();
    }
}