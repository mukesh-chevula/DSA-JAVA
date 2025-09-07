class MagicDictionary {
    class TrieNode {
        TrieNode[] refs;
        boolean flag;

        TrieNode() {
            this.refs = new TrieNode[26];
            this.flag = false;
        }
    }

    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
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

    public void buildDict(String[] dict) {
        for (String s : dict) {
            insert(s);
        }
    }

    public boolean search(String searchWord) {
        char[] arr = searchWord.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (arr[i] == c)
                    continue;
                char org = arr[i];
                arr[i] = c;
                if (searchTrie(arr))
                    return true;
                arr[i] = org;
            }
        }
        return false;
    }

    public boolean searchTrie(char[] word) {
        TrieNode cur = root;
        for (char c : word) {
            if (cur.refs[c - 'a'] == null)
                return false;
            cur = cur.refs[c - 'a'];
        }
        return cur.flag;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */