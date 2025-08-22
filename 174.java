class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(arr[i], Integer.MIN_VALUE);

        return dp(dungeon, arr, m, n, 0, 0);
    }

    int dp(int[][] dungeon, int[][] arr, int m, int n, int i, int j) {
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE; 
        }
        if (arr[i][j] != Integer.MIN_VALUE) {
            return arr[i][j];
        }
        if (i == m - 1 && j == n - 1) {
            arr[i][j] = Math.max(1, 1 - dungeon[i][j]);
            return arr[i][j];
        }
        arr[i][j] = Math.max(1, Math.min(
            dp(dungeon, arr, m, n, i, j + 1),
            dp(dungeon, arr, m, n, i + 1, j)
        ) - dungeon[i][j]);
        return arr[i][j];
    }
}