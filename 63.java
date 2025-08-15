class Solution {
    int[][] memo;
    int m, n;
    int[][] obstacleGrid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;
        this.memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        return dp(m - 1, n - 1);
    }

    private int dp(int i, int j) {
        if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        memo[i][j] = dp(i - 1, j) + dp(i, j - 1);
        return memo[i][j];
    }
}