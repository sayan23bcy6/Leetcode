class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    numIslands += dfs(grid, i, j);
                }
            }
        }
        
        return numIslands;
    }
    
    private int dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        if (i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j] == '0') {
            return 0;
        }
        
        grid[i][j] = '0';
        
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        
        return 1;
    }
}
