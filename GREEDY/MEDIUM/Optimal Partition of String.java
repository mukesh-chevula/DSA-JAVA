class Solution {
    public int partitionString(String s) {
        int n=s.length();
        int[] freq=new int[26];
        int res=1;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(freq[c-'a']>0){
                res++;
                freq=new int[26];
                freq[c-'a']=1;
            }else{
                freq[c-'a']=1;
            }
        }
        return res;
    }
}