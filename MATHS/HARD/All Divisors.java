class Solution {
    public void print_divisors(int N) {
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();

        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                small.add(i);
                if (i != N / i) {
                    large.add(N / i);
                }
            }
        }

        Collections.reverse(large);

        for(int i=0;i<small.size();i++) System.out.print(small.get(i)+" ");
        for(int i=0;i<large.size();i++) System.out.print(large.get(i)+" ");
    }
}
