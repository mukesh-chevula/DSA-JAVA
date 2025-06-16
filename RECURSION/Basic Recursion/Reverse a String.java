class Solution{
    public String helper(String s, int k, StringBuilder t){
        if(k<0) return t.toString();
        t.append(s.charAt(k));
        return helper(s,k-1,t);
    }
    public String reverse(String s){
        StringBuilder t=new StringBuilder();
        return helper(s,s.length()-1,t);
    }
}