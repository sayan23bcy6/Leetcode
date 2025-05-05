class Solution {
    static final int MOD = 1_000_000_007;
    Integer[] dp;

    public int numTilings(int n) {
        dp = new Integer[n + 1];
        return recur(n);
    }

    int recur(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        if (dp[n] != null) return dp[n];

        dp[n] = (int)(((2L * recur(n - 1) + recur(n - 3)) % MOD));
        return dp[n];
    }
}
