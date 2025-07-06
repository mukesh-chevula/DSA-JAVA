class Solution {
    public String findOrder(String[] words) {
        // code here
        int n=words.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<26;i++) adj.add(new ArrayList<>());
        int[] indegree=new int[26];
        Set<Integer> chars = new HashSet<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                chars.add(c - 'a');
            }
        }
        
        for(int i=0;i<n-1;i++){
            String first=words[i],second=words[i+1];
            int j=0;
            int minLen=Math.min(first.length(), second.length());
            while(j<Math.min(first.length(), second.length()) && first.charAt(j)==second.charAt(j)) j++;
            if(j == minLen && first.length() > second.length()) return "";
            if(j<minLen){
                adj.get(first.charAt(j)-'a').add(second.charAt(j)-'a');
                indegree[second.charAt(j)-'a']++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i : chars) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        StringBuilder res=new StringBuilder();
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            res.append((char)(node + 'a'));
            
            for(int predecessor : adj.get(node)) {
                indegree[predecessor]--;
                if(indegree[predecessor] == 0) {
                    queue.offer(predecessor);
                }
            }
        }
        return res.length() == chars.size() ? res.toString() : "";
    }
}