class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int j = 1; j < n; j++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0, k = j; i < m && k < n; i++, k++) {
                pq.add(grid[i][k]);
            }
            for (int i = 0, k = j; i < m && k < n; i++, k++) {
                grid[i][k] = pq.poll();
            }
        }

        for (int i = 0; i < m; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0, k = i; j < n && k < m; j++, k++) {
                pq.add(grid[k][j]);
            }
            for (int j = 0, k = i; j < n && k < m; j++, k++) {
                grid[k][j] = pq.poll();
            }
        }

        return grid;
    }
}