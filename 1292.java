class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] pref = new int[m][n];

        pref[0][0] = mat[0][0];

        for (int j = 1; j < n; j++)
            pref[0][j] = pref[0][j-1] + mat[0][j];

        for (int i = 1; i < m; i++)
            pref[i][0] = pref[i-1][0] + mat[i][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pref[i][j] = mat[i][j]
                           + pref[i-1][j]
                           + pref[i][j-1]
                           - pref[i-1][j-1];
            }
        }

        int ans = 0;
        int maxK = Math.min(m, n);

        for (int k = 1; k <= maxK; k++) {
            for (int i = 0; i + k - 1 < m; i++) {
                for (int j = 0; j + k - 1 < n; j++) {

                    int r = i + k - 1;
                    int c = j + k - 1;

                    int sum = pref[r][c];
                    if (i > 0) sum -= pref[i-1][c];
                    if (j > 0) sum -= pref[r][j-1];
                    if (i > 0 && j > 0) sum += pref[i-1][j-1];

                    if (sum <= threshold)
                        ans = Math.max(ans, k);
                }
            }
        }
        return ans;
    }
}
