class Solution {
    public int findMaxFish(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]>0)
                max=Math.max(max,bfs(grid,i,j));
            }
        }
        return max;
    }
    public int bfs(int[][] grid,int i,int j)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0)
        return 0;
        int temp=grid[i][j];
        grid[i][j]=0;
        return bfs(grid,i+1,j)+bfs(grid,i-1,j)+bfs(grid,i,j+1)+bfs(grid,i,j-1)+temp;
    }
}