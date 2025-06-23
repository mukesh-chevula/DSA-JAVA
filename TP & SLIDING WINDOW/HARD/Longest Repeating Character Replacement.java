class Solution {
    public int characterReplacement(String s, int k) {
        int[] map=new int[26];
        int l=0,r=0,maxfreq=0,res=0;

        while(r<s.length()){
            char c= s.charAt(r);
            map[c-'A']++;
            if(map[c-'A']>maxfreq){
                maxfreq=map[c-'A'];
            }
            while((r-l+1-maxfreq)>k){
                map[s.charAt(l)-'A']--;
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}