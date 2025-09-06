class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return intbr(n, dp);
    }
    int intbr(int n, int[] dp) {
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * Math.max(n - i, intbr(n - i, dp)));
        }
        dp[n] = max;
        return max;
    }
}
