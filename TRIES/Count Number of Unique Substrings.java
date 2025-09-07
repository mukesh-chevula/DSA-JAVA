/*You are required to complete this method */
class GfG {
    class TrieNode {
        TrieNode[] refs = new TrieNode[26];
        boolean end = false;
    }
    private TrieNode root=new TrieNode();
    
    public int countDistinctSubstring(String st) {
        // your code here
        int res=0;
        int n=st.length();
        
        for(int i=0;i<n;i++){
            TrieNode cur=root;
            for(int j=i;j<n;j++){
                char c=st.charAt(j);
                if(cur.refs[c-'a']==null){
                    res++;
                    cur.refs[c-'a']=new TrieNode();
                }
                cur=cur.refs[c-'a'];
            }
        }
        return res+1;
    }
}