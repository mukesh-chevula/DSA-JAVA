class Solution {
    class TrieNode {
        TrieNode[] refs = new TrieNode[2];
    }

    private static final int BITS = 32;
    private TrieNode root = new TrieNode();

    public void insert(int num) {
        TrieNode cur = root;
        for (int i = BITS - 1; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cur.refs[bit] == null) {
                cur.refs[bit] = new TrieNode();
            }
            cur = cur.refs[bit];
        }
    }

    public int findMaximumXOR(int[] nums) {
        for (int i : nums)
            insert(i);

        int res = 0;

        for (int num : nums) {
            int xor = 0;
            TrieNode cur = root;
            for (int i = BITS - 1; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 1) {
                    if (cur.refs[0] != null) {
                        cur = cur.refs[0];
                        xor = (xor << 1) + 1;
                    } else {
                        cur = cur.refs[1];
                        xor = xor << 1;
                    }
                } else {
                    if (cur.refs[1] != null) {
                        cur = cur.refs[1];
                        xor = (xor << 1) + 1;
                    } else {
                        cur = cur.refs[0];
                        xor = xor << 1;
                    }
                }
            }
            res = Math.max(xor, res);
        }
        return res;
    }
}