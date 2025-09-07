class WordDictionary {
    class TrieNode {
        TrieNode[] refs = new TrieNode[26];
        boolean flag;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.refs[c - 'a'] == null)
                cur.refs[c - 'a'] = new TrieNode();
            cur = cur.refs[c - 'a'];
        }
        cur.flag = true;
    }

    public boolean search(String word) {
        return helper(root, word, 0);
    }

    private boolean helper(TrieNode cur, String word, int i) {
        if (i == word.length()) {
            return cur.flag;
        }

        char c = word.charAt(i);

        if (c == '.') {
            for (TrieNode node : cur.refs) {
                if (node != null && helper(node, word, i + 1)){
                        return true;
                }
            }
        } else {
            if (cur.refs[c - 'a'] == null)
                return false;
            return helper(cur.refs[c - 'a'], word, i + 1);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */