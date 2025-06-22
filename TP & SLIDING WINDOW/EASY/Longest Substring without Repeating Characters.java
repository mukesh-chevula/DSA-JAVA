class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;

        HashSet<Character> set = new HashSet<>();
        int l=0;
        int r=0;
        int maxLen=0;
        while(r<s.length()){
            char c=s.charAt(r);
            if(!set.contains(c)){
                set.add(c);
                maxLen=Math.max(maxLen,r-l+1);
                r++;
            }else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        return maxLen;
    }
}