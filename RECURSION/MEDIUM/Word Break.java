class Solution {
    private Map<String, Boolean> map=new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0) return true;
        if(map.containsKey(s)) return map.get(s);

        for(String i:wordDict){
            if(s.startsWith(i)){
                if (wordBreak(s.substring(i.length()), wordDict)) {
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }
}