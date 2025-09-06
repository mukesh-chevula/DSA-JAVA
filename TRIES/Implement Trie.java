class Trie {
    class TrieNode{
        TrieNode[] refs;
        boolean flag;
        TrieNode(){
            this.refs=new TrieNode[26];
            this.flag=false;
        }
    }
    private final TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.refs[idx] == null) {
                cur.refs[idx] = new TrieNode();
            }
            cur = cur.refs[idx];
        }
        cur.flag = true;
    }
    
    public boolean search(String word) {
        TrieNode cur=root;
        int i=0;
        while(i < word.length()){
            int idx=word.charAt(i)-'a';
            if(cur.refs[idx]==null) return false;
            cur=cur.refs[idx];
            i++;
        }
        return cur.flag;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        int i=0;
        while(i < prefix.length()){
            int idx=prefix.charAt(i)-'a';
            if(cur.refs[idx]==null) return false;
            cur=cur.refs[idx];
            i++;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */