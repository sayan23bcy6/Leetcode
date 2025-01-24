class Solution {
    public void rotate(int[][] matrix) 
    {int i=0,j=0,k=0;
    int n=matrix.length;
     int[][] mat=new int[n][n];   
     for(i=0;i<n;i++)
     {
         for(j=0;j<n;j++)
         {
             mat[i][j]=matrix[i][j];
         }
     }
     for(i=n-1;i>=0;i--)
     {
         for(j=0;j<n;j++)
         {
             matrix[j][k]=mat[i][j];

         }k++;
     }
     
     
    }
}