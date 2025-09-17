class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dynamic(matrix, dp, m, n, i, j));
            }
        }
        return max;
    }

    int dynamic(int matrix[][], int dp[][], int m, int n, int i, int j) {
        if (dp[i][j] != -1)
            return dp[i][j];
        int maxLen = 1; 
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];
            if (ni >= 0 && nj >= 0 && ni < m && nj < n && matrix[ni][nj] > matrix[i][j]) {
                maxLen = Math.max(maxLen, 1 + dynamic(matrix, dp, m, n, ni, nj));
            }
        }
        dp[i][j] = maxLen;
        return dp[i][j];
    }
}
