class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j];
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        int total = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                total += dp[i][j];
            }
        }
        
        return total;
    }
}