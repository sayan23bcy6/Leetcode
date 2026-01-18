class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m + 1][n + 1];
        int[][] col = new int[m + 1][n + 1];
        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 2][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i + 1][j + 1] = row[i + 1][j] + grid[i][j];
                col[i + 1][j + 1] = col[i][j + 1] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j + 1] = diag2[i][j + 2] + grid[i][j];
            }
        }

        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    int target = row[i + 1][j + k] - row[i + 1][j];

                    boolean ok = true;

                    if (diag1[i + k][j + k] - diag1[i][j] != target) ok = false;
                    if (diag2[i + k][j + 1] - diag2[i][j + k + 1] != target) ok = false;

                    for (int t = 0; t < k && ok; t++) {
                        if (row[i + t + 1][j + k] - row[i + t + 1][j] != target) ok = false;
                        if (col[i + k][j + t + 1] - col[i][j + t + 1] != target) ok = false;
                    }

                    if (ok) return k;
                }
            }
        }

        return 1;
    }
}
