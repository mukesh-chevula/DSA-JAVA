class Solution {
    public int numberOfSubstrings(String s) {
        int ac=0,bc=0,cc=0,count=0,l=0;
        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);

            if(c=='a') ac++;
            else if(c=='b') bc++;
            else if(c=='c') cc++;

            while(ac>0 && bc>0 && cc>0){
                count+=s.length()-r;
                char leftChar=s.charAt(l);
                
                if(leftChar=='a') ac--;
                else if(leftChar=='b') bc--;
                else if(leftChar=='c') cc--;

                l++;
            }
        }
        return count;
    }
}
