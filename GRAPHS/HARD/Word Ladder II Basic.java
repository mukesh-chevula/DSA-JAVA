class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n=wordList.size();
        int wl=beginWord.length();
        Set<String> words=new HashSet<>();
        Map<Integer, Set<Character>> charmap=new HashMap<>();
        for(int i=0;i<wl;i++) charmap.put(i,new HashSet<>());
        for(String s:wordList){
            words.add(s);
            for(int i=0;i<wl;i++){
                charmap.get(i).add(s.charAt(i));
            }
        }
        Queue<List<String>> q=new LinkedList<>();
        List<String> l=new ArrayList<>();
        l.add(beginWord);
        q.offer(l);
        List<String> used=new ArrayList<>();
        used.add(beginWord);
        int level=0;
        List<List<String>> res=new ArrayList<>();
        while(!q.isEmpty()){
            List<String> list=q.poll();
            if(level<list.size()){
                level++;
                for(String s:used) words.remove(s);
                used.clear();
            }
            String cur=list.get(list.size()-1);
            if(cur.equals(endWord)){
                if(res.size()==0) res.add(list);
                else if(list.size()==res.get(0).size()) res.add(list);
            }
            for(int i=0;i<wl;i++){
                for(Character c: charmap.get(i)){
                    char[] newword=cur.toCharArray();
                    newword[i]=c;
                    String nW=new String(newword);
                    if(words.contains(nW)){
                        list.add(nW);
                        List<String> temp=new ArrayList<>(list);
                        q.offer(temp);
                        used.add(nW);
                        list.remove(list.size()-1);
                    }
                }
            }
        }
        return res;
    }
}