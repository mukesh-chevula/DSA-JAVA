class Solution {
    class TrieNode {
        TrieNode[] refs = new TrieNode[2];
    }

    private static final int BITS = 32;
    private TrieNode root = new TrieNode();

    public void insert(int x) {
        TrieNode cur = root;
        for (int i = BITS - 1; i >= 0; i--) {
            int bit = (x >> i) & 1;
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

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[][] offq = new int[n][3];

        for (int i = 0; i < n; i++) {
            offq[i][0] = queries[i][0];
            offq[i][1] = queries[i][1];
            offq[i][2] = i;
        }

        Arrays.sort(offq, (a, b) -> a[1] - b[1]);
        Arrays.sort(nums);
        int[] res = new int[n];
        int prev = 0;

        for (int j = 0; j < n; j++) {
            int x = offq[j][0], limit = offq[j][1], idx = offq[j][2];

            while (prev < nums.length && nums[prev] <= limit) {
                insert(nums[prev]);
                prev++;
            }

            TrieNode cur = root;
            if (cur.refs[0] == null && cur.refs[1] == null) {
                res[idx] = -1;
                continue;
            }
            int xor = 0;
            for (int i = BITS - 1; i >= 0; i--) {
                int bit = (x >> i) & 1;
                if (cur.refs[1 - bit] != null) {
                    cur = cur.refs[1 - bit];
                    xor = (xor << 1) | 1;
                } else {
                    cur = cur.refs[bit];
                    xor = (xor << 1);
                }
            }
            res[idx] = xor;
        }
        return res;
    }
}