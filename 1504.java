class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] right = new int[m][n];
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0) right[i][j] = 0;
                else if (j == n - 1) right[i][j] = 1;
                else right[i][j] = 1 + right[i][j + 1];
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    arr[i][j] = 0;
                    continue;
                }
                int minWidth = Integer.MAX_VALUE;
                for (int k = i; k < m; k++) {
                    if (mat[k][j] == 0) break;
                    minWidth = Math.min(minWidth, right[k][j]);
                    arr[i][j] += minWidth;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += arr[i][j];
            }
        }
        return count;
    }
}
