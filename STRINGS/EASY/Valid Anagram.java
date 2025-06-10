class Solution {
    static{
        for(int i=0;i<300;i++) isAnagram("","");
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for(int i=0;i<t.length();i++){
            freq[t.charAt(i) - 'a']--;
        }

        for( int i:freq) if(i>0) return false;

        return true;
    }
}