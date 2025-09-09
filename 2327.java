class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long sharing = 0;
        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) sharing = (sharing + dp[day - delay]) % MOD;
            if (day - forget >= 1) sharing = (sharing - dp[day - forget] + MOD) % MOD;
            dp[day] = sharing;
        }
        long res = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) res = (res + dp[day]) % MOD;
        }
        return (int) res;
    }
}
