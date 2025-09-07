class Solution {
    class TrieNode {
        TrieNode[] refs = new TrieNode[26];;
        boolean flag;
        String word;
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
        cur.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String s : words)
            insert(s);

        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        char c = board[i][j];
        if (c < 'a' || c > 'z' || cur.refs[c - 'a'] == null)
            return;
        cur = cur.refs[c - 'a'];
        if (cur.flag) {
            res.add(cur.word);
            cur.flag = false;
        }
        board[i][j] = '#';

        dfs(board, i + 1, j, cur, res);
        dfs(board, i - 1, j, cur, res);
        dfs(board, i, j + 1, cur, res);
        dfs(board, i, j - 1, cur, res);

        board[i][j] = c;
    }
}