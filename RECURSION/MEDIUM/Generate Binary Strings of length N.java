// User function Template for Java

class Solution {
    public static List<String> generateBinaryStrings(int n) {
        // code here
        List<String> res=new ArrayList<>();
        helper(0,n,res,new StringBuilder());
        return res;
    }
    public static void helper(int index, int length,List<String> res,StringBuilder cur){
        if(index>=length){
            res.add(cur.toString());
            return;
        }
        if(cur.length()>=length) return;
        
        cur.append(0);
        helper(index+1,length,res,cur);
        cur.deleteCharAt(cur.length()-1);
        
        if(cur.length()==0 || cur.charAt(cur.length()-1)!='1'){
            cur.append(1);
            helper(index+1,length,res,cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
