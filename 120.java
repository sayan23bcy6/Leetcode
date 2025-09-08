class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int n=triangle.get(m-1).size();
        int arr[][]=new int[m][n];
        for(int[] ar:arr)
        Arrays.fill(ar,Integer.MAX_VALUE);
        return dp(triangle,arr,0,0,m,n);
    }
    int dp(List<List<Integer>> triangle,int[][] arr,int row,int col,int m,int n)
    {   if(row>=m || col>=n)
        return 0;
        if(arr[row][col]!=Integer.MAX_VALUE)
        return arr[row][col];
        int num=triangle.get(row).get(col);
        arr[row][col]=num+Math.min(dp(triangle,arr,row+1,col,m,n),dp(triangle,arr,row+1,col+1,m,n));
        return arr[row][col];
    }
}