class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][]=new int[m][n];
        for (int[] row : arr) 
        Arrays.fill(row, 0);
        return dp(0,0,m,n,arr);
    }
    int dp(int i,int j,int m,int n,int arr[][])
    {
        if(i<m-1 && j<n-1)
        {if(arr[i][j]!=0)
        return arr[i][j];
        else
        arr[i][j]=dp(i+1,j,m,n,arr)+dp(i,j+1,m,n,arr);
            return arr[i][j];
        }
        else if(j==(n-1) && i<m-1)
        {if(arr[i][j]!=0)
        return arr[i][j];
        else
        arr[i][j]=dp(i+1,j,m,n,arr);
            return arr[i][j];
        }
        else if(i==(m-1) && j<n-1)
        {if(arr[i][j]!=0)
        return arr[i][j];
        else
        arr[i][j]=dp(i,j+1,m,n,arr);
            return arr[i][j];
        }
            return 1;
    }
}