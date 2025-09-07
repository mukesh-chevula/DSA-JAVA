class Solution {
    class TrieNode {
        TrieNode[] refs = new TrieNode[26];
        boolean end = false;
    }
    private TrieNode root=new TrieNode();
    
    public void insert(String word){
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.refs[c-'a']==null)cur.refs[c-'a']=new TrieNode();
            cur=cur.refs[c-'a'];
        }
        cur.end=true;
    }
    public boolean isValid(String w){
        TrieNode cur=root;
        for(char c: w.toCharArray()){
            cur = cur.refs[c - 'a'];
            if(cur==null || cur.end==false) return false;
        }
        return true;
    }
    public String longestValidWord(String[] words) {
        // code here
        for(String w:words) insert(w);
        
        String ans="";
        
        for(String w:words){
            if(isValid(w)){
                if(w.length()> ans.length() || (w.length()==ans.length() && w.compareTo(ans)<0)){
                    ans=w;
                }
            }
        }
        return ans;
    }
}