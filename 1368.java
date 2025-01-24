public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
       
        Deque<int[]> deque = new LinkedList<>();
        cost[0][0] = 0;
        deque.offerFirst(new int[]{0, 0});
        
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int x = curr[0], y = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = x + dirs[i][0];
                int newY = y + dirs[i][1];
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newCost = cost[x][y] + (grid[x][y] == i + 1 ? 0 : 1);
                    
                    if (newCost < cost[newX][newY]) {
                        cost[newX][newY] = newCost;
                        if (grid[x][y] == i + 1) {
                            deque.offerFirst(new int[]{newX, newY});
                        } else {
                            deque.offerLast(new int[]{newX, newY});
                        }
                    }
                }
            }
        }
        
        return cost[m - 1][n - 1];
    }}