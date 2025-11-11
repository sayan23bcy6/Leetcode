class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] zeros = new int[len];
        int[] ones = new int[len];

        for (int i = 0; i < len; i++) {
            int z = 0, o = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') z++;
                else o++;
            }
            zeros[i] = z;
            ones[i] = o;
        }

        int[][][] dp = new int[len][m + 1][n + 1];
        for (int i = 0; i < len; i++)
            for (int j = 0; j <= m; j++)
                for (int k = 0; k <= n; k++)
                    dp[i][j][k] = -1;

        return helper(0, m, n, zeros, ones, dp);
    }

    private int helper(int i, int m, int n, int[] zeros, int[] ones, int[][][] dp) {
        if (i == zeros.length) return 0;
        if (dp[i][m][n] != -1) return dp[i][m][n];

        int res = helper(i + 1, m, n, zeros, ones, dp);

        if (m >= zeros[i] && n >= ones[i]) {
            res = Math.max(res, 1 + helper(i + 1, m - zeros[i], n - ones[i], zeros, ones, dp));
        }

        return dp[i][m][n] = res;
    }
}
