class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int k=0;
        int arr[]=new int[m*n];
        int i=0,j=0;
        while(i<m && j<n)
        {arr[k++]=mat[i][j];
            if((i+j)%2==0)
            {
                if(i-1<0 && j+1>=n)
                {
                    i++;
                }
                else if(i-1<0)
                {
                    j++;
                }
                else if(j+1>=n)
                {
                    i++;
                }
                else
                {
                    i--;
                    j++;
                }
            }
            else
            {   if(j-1<0 && i+1>=m)
                {
                    j++;
                }            
                else if(j-1<0)
                {
                    i++;
                }
                else if(i+1>=m)
                {
                    j++;
                }
                else
                {
                    i++;
                    j--;
                }
            }
        }
        return arr;
    }
}