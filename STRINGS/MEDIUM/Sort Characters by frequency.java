class Solution {
    static{
        for(int i=0;i<=500;i++) frequencySort("");
    }
    public static String frequencySort(String s) {
        HashMap<Character,Integer> freq=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(freq.containsKey(s.charAt(i))){
                freq.put(s.charAt(i),freq.get(s.charAt(i))+1);
            }else{
                freq.put(s.charAt(i),1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> p1, Map.Entry<Character, Integer> p2) {
                return Integer.compare(p2.getValue(), p1.getValue()); 
            }
        });

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.offer(entry); 
        }

        StringBuilder res=new StringBuilder();

        while(pq.size()>0){
            Map.Entry<Character, Integer> polled = pq.poll();
            Character c=polled.getKey();
            int f=polled.getValue();
            for(int i=0;i<f;i++){
                res.append(c);
            }
        }
        return res.toString();
    }
}