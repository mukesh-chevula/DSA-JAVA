class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(0,s,res,new ArrayList<>());
        return res;
    }
    public void helper(int index, String s, List<List<String>> res, List<String> cur){
        if(index==s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                cur.add(s.substring(index,i+1));
                helper(i+1,s,res,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}