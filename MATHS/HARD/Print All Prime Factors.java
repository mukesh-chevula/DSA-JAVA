

class Solution {
    public int[] AllPrimeFactors(int N) {
        List<Integer> res = new ArrayList<>();

        if ((N &1) == 0) {
            res.add(2);
            while ((N &1) == 0)
                N =N>> 1;
        }

        for (int i = 3; i * i <= N; i += 2) {
            if (N % i == 0) {
                res.add(i);
                while (N % i == 0)
                    N /= i;
            }
        }

        if (N > 2)
            res.add(N);

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}