class Solution {
    public char kthCharacter(int k) {
        String res=new String("a");

        return helper(res,k);
    }

    public char helper(String res,int k){
        if(res.length()>=k) return res.charAt(k-1);

        StringBuilder s = new StringBuilder();
        for(int i=0;i<res.length();i++){
            char next = (char) (res.charAt(i) + 1);
            s.append(next);
        }

        return helper(res+s.toString(),k);
    }
}