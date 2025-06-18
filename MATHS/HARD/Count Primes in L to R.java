// User function Template for Java

class Solution {
    int countPrimes(int L, int R) {
        // code here
        int n=R+1;
        int[] isPrime = new int[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = 1; 
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i] == 1) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            isPrime[i] += isPrime[i - 1];
        }
        return isPrime[R]-isPrime[L-1];
        
    }
};