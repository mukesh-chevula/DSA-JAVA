class Solution {
    public String minWindow(String s, String t) {
        int sl=s.length(),tl=t.length();
        if(sl<tl) return "";
        if(s.equals(t)) return s;

        int minL=-1,minR=-1,l=0,r=0,count=0,minLen = Integer.MAX_VALUE;
        int[] hash=new int[128];

        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }

        while(r<sl){
            char c=s.charAt(r);

            hash[c]--;
            if (hash[c] >= 0) count++;

            while(count==tl){
                if((r-l+1)<minLen){
                    minLen=r-l+1;
                    minL=l;
                    minR=r;
                }
                char cl = s.charAt(l);
                hash[cl]++;
                if (hash[cl] > 0) count--;
                l++;
            }
            r++;
        }
        return minL == -1 ? "" : s.substring(minL, minR + 1);
    }x
}