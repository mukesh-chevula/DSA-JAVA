class Solution {
    class TrieNode {
        TrieNode[] refs;
        boolean flag;

        TrieNode() {
            this.refs = new TrieNode[26];
            this.flag = false;
        }
    }

    private final TrieNode root;

    public Solution() {
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

    public String search(String word) {
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (cur.refs[c - 'a'] == null)
                break;
            sb.append(c);
            cur = cur.refs[c - 'a'];
            if (cur.flag)
                return sb.toString();
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] sent = sentence.split(" ");
        for (String s : dictionary)
            insert(s);

        for (int i = 0; i < sent.length; i++) {
            sent[i] = search(sent[i]);
        }
        return String.join(" ", sent);
    }
}