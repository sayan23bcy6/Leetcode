public class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long[] topPrefixSum = new long[n];
        long[] bottomPrefixSum = new long[n];
        
        topPrefixSum[0] = grid[0][0];
        bottomPrefixSum[0] = grid[1][0];
        
        for (int i = 1; i < n; i++) {
            topPrefixSum[i] = topPrefixSum[i - 1] + grid[0][i];
            bottomPrefixSum[i] = bottomPrefixSum[i - 1] + grid[1][i];
        }
        
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long topPoints = i + 1 < n ? topPrefixSum[n - 1] - topPrefixSum[i] : 0;
            long bottomPoints = i > 0 ? bottomPrefixSum[i - 1] : 0;
            long secondRobotPoints = Math.max(topPoints, bottomPoints);
            result = Math.min(result, secondRobotPoints);
        }
        
        return result;
    }
}
