class Solution {
    static int MAX = 200005;
    static int[] spf = new int[MAX];

    static void sieve() {
        for (int i = 2; i < MAX; i++) spf[i] = i;

        for (int i = 2; i * i < MAX; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < MAX; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        sieve();
        List<Integer> res = new ArrayList<>();

        while (N > 1) {
            int prime = spf[N];
            res.add(prime);
            N /= prime;

        }

        return res;
    }
}
