class Solution {
    public int maxDepth(String s) {
        int max_c=0,c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                c++;
                max_c=Math.max(max_c,c);
            }else if(s.charAt(i)==')'){
                c--;
            }
        }
        return max_c;
    }
}