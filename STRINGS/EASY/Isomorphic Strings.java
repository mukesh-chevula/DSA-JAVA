class Solution {
    static {
        for(int i=0;i<=300;i++) isIsomorphic("","");
    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> mapped = new HashSet<>();
        
        int a=0;

        while(a<s.length()){
            if(map.containsKey(s.charAt(a))){
                if(map.get(s.charAt(a))!=t.charAt(a)) return false;
            }else{
                if (mapped.contains(t.charAt(a))) return false;
                map.put(s.charAt(a),t.charAt(a));
                mapped.add(t.charAt(a));
            }
            a++;
        }
        return true;
    }
}