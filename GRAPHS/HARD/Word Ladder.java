import java.util.*;

class Solution {
    Set<String> words;
    Map<Integer,Set<Character>> charmap;
    String getString(String begin,int index,char c){
        char[] str=begin.toCharArray();
        str[index]=c;
        return new String(str);
    }
    boolean isValid(String begin, String end){
        int diff = 0;
        for(int i = 0; i < begin.length(); i++){
            if(begin.charAt(i) != end.charAt(i)){
                diff++;
                if(diff > 1) return false;
            }
        }
        return diff == 1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        int n=wordList.size();
        words=new HashSet<>();
        charmap=new HashMap<>();
        Map<String,Boolean> visited=new HashMap<>();
        for(int i=0;i<beginWord.length();i++){
            charmap.put(i, new HashSet<>());
        }
        for(String s: wordList){
            words.add(s);
            visited.put(s,false);
            for(int i=0;i<s.length();i++){
                charmap.get(i).add(s.charAt(i));
            }
        }
        if(!words.contains(endWord)) return 0;
        
        // Add beginWord to visited map
        visited.put(beginWord, false);
        
        Map<String,List<String>> adj=new HashMap<>();
        for(int i=0;i<beginWord.length();i++){
            for(Character c:charmap.get(i)){
                String next=getString(beginWord,i,c);
                if(words.contains(next) && !next.equals(beginWord)){
                    if(!adj.containsKey(beginWord)){
                        List<String> t=new ArrayList<>();
                        t.add(next);
                        adj.put(beginWord,new ArrayList<>(t));
                    }else{
                        adj.get(beginWord).add(next);
                    }
                }
            }
        }
        
        for(int i=0;i<n-1;i++){
            String cur=wordList.get(i);
            for(int j=i+1;j<n;j++){
                String next=wordList.get(j);
                if(isValid(cur,next)){
                    if(!adj.containsKey(cur)){
                        List<String> t=new ArrayList<>();
                        t.add(next);
                        adj.put(cur,new ArrayList<>(t));
                    }else{
                        adj.get(cur).add(next);
                    }
                    if(!adj.containsKey(next)){
                        List<String> t=new ArrayList<>();
                        t.add(cur);
                        adj.put(next,new ArrayList<>(t));
                    }else{
                        adj.get(next).add(cur);
                    }
                }
            }
        }
        
        if(!adj.containsKey(beginWord)){
            return 0;
        }
        
        Queue<Pair> q=new LinkedList<>();
        visited.put(beginWord, true);
        q.offer(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair p=q.poll();
            String s=p.s;
            int curDist=p.dist;
            
            if(adj.get(s) != null) {
                for(String child:adj.get(s)){
                    if(!visited.get(child)){
                        if(child.equals(endWord)) return curDist+1;
                        visited.put(child, true);
                        q.offer(new Pair(child,curDist+1));
                    }
                }
            }
        }
        return 0;
    }
    private class Pair{
        String s;
        int dist;
        Pair(String s, int dist){
            this.s=s;
            this.dist=dist;
        }
    }
}