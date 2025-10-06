class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1], t = cur[2];
            if (i == n - 1 && j == n - 1) return t;
            if (visited[i][j]) continue;
            visited[i][j] = true;
            for (int[] d : dirs) {
                int x = i + d[0], y = j + d[1];
                if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                    pq.offer(new int[]{x, y, Math.max(t, grid[x][y])});
                }
            }
        }
        return -1;
    }
}
