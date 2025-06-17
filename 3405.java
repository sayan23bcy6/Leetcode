class Solution {

    private static final int MOD = 1_000_000_007;
    private static long[] fact  = {1};
    private static long[] ifact = {1};

    private static long powMod(long a, long e) {
        long res = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }

    private static void ensureFactorials(int n) {
        if (fact.length > n) return;
        int old = fact.length - 1;
        int newSize = n + 1;
        long[] nf = new long[newSize];
        long[] ni = new long[newSize];
        System.arraycopy(fact, 0, nf, 0, fact.length);
        System.arraycopy(ifact, 0, ni, 0, ifact.length);
        for (int i = old + 1; i <= n; i++)
            nf[i] = nf[i - 1] * i % MOD;
        ni[n] = powMod(nf[n], MOD - 2);
        for (int i = n; i > old; i--)
            ni[i - 1] = ni[i] * i % MOD;
        fact  = nf;
        ifact = ni;
    }

    private static long nCk(int n, int k) {
        if (k < 0 || k > n) return 0;
        ensureFactorials(n);
        return fact[n] * ifact[k] % MOD * ifact[n - k] % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        if (k < 0 || k > n - 1) return 0;
        long comb  = nCk(n - 1, k);
        long pow   = (n - k - 1 >= 0) ? powMod(m - 1, n - k - 1) : 1;
        long ans   = comb * m % MOD * pow % MOD;
        return (int) ans;
    }
}
/*C(n−1,k)⋅m⋅(m−1)n−k−1
where C(n−1,k) is the binomial coefficient "n-1 choose k", m is the number of distinct integers, and (m-1)^(n-k-1) is the number of ways to fill the remaining positions with integers different from the first one.
​*/
 
