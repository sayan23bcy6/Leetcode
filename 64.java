class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int arr[][]=new int[m][n];
        for(int[] ar:arr)
        {
            Arrays.fill(ar,-1);
        }
        return dp(arr,grid,0,0,m,n);
    }
    int dp(int[][] arr,int[][] grid,int i,int j,int m,int n)
    {   if(arr[i][j]!=-1)
        return arr[i][j];
        if(i==m-1 && j==n-1)
        {
            return grid[i][j];
        }
        else if(j==n-1)
        {
            arr[i][j]=grid[i][j]+dp(arr,grid,i+1,j,m,n);
            return arr[i][j];
        }
        else if(i==m-1)
        {   arr[i][j]=grid[i][j]+dp(arr,grid,i,j+1,m,n);
            return arr[i][j];
        }
            arr[i][j]=grid[i][j]+Math.min(dp(arr,grid,i,j+1,m,n),dp(arr,grid,i+1,j,m,n));
            return arr[i][j];
    }
}