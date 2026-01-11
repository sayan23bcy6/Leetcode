class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = j; k < n; k++) {
                    min = Math.min(min, heights[k]);
                    if (min == 0) break;
                    max = Math.max(max, min * (k - j + 1));
                }
            }
        }
        return max;
    }
}
