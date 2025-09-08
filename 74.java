class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        return search(target,m,n,matrix,0,m*n-1);
    }
    boolean search(int target,int m,int n,int[][] matrix,int low,int high)
    {
        if(low>high) return false;
        int mid=low+(high-low)/2;
        int num=matrix[mid/n][mid%n];
        if(target<num)
        {
            return search(target,m,n,matrix,low,mid-1);
        }
        else if(target>num)
        {
            return search(target,m,n,matrix,mid+1,high);
        }
        else
        {
            return true;
        }
    }  
}
