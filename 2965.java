class Solution {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length; // Since it's an n x n grid
        int N = n * n; // Total numbers should be from 1 to N

        // Expected sum and sum of squares
        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSumSq = (long) N * (N + 1) * (2 * N + 1) / 6;

        // Actual sum and sum of squares
        long actualSum = 0, actualSumSq = 0;

        for (int[] row : grid) {
            for (int num : row) {
                actualSum += num;
                actualSumSq += (long) num * num;
            }
        }

        // Calculate differences
        long sumDiff = actualSum - expectedSum;  // a - b
        long sumSqDiff = actualSumSq - expectedSumSq;  // a^2 - b^2

        // Solve for a and b
        long sumAB = sumSqDiff / sumDiff;  // a + b
        int a = (int) ((sumAB + sumDiff) / 2);
        int b = (int) (sumAB - a);

        return new int[]{a, b};
    }

}