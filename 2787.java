class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; ; i++) {
            int p = (int) Math.pow(i, x);
            if (p > n) {
                break;
            }
            for (int j = n; j >= p; j--) {
                dp[j] = (dp[j] + dp[j - p]) % MOD;
            }
        }
        return (int) dp[n];
    }
}