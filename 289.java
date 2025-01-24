class Solution {
    public int count(int[][] mat, int i, int j) {
    int sum = 0;
    if (i - 1 >= 0 && mat[i - 1][j] == 1) sum++;
    if (i + 1 < mat.length && mat[i + 1][j] == 1) sum++;
    if (j - 1 >= 0 && mat[i][j - 1] == 1) sum++;
    if (j + 1 < mat[0].length && mat[i][j + 1] == 1) sum++;
    if (i - 1 >= 0 && j - 1 >= 0 && mat[i - 1][j - 1] == 1) sum++;
    if (i + 1 < mat.length && j - 1 >= 0 && mat[i + 1][j - 1] == 1) sum++;
    if (i - 1 >= 0 && j + 1 < mat[0].length && mat[i - 1][j + 1] == 1) sum++;
    if (i + 1 < mat.length && j + 1 < mat[0].length && mat[i + 1][j + 1] == 1) sum++;
    return sum;
}

    public void gameOfLife(int[][] board) {
        int arr[][]=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==1 && count(board,i,j)<2)
                {
                    arr[i][j]=0;
                }
                else if(board[i][j]==1 && count(board,i,j)>=2 && count(board,i,j)<=3)
                {
                    arr[i][j]=1;
                }
                else if(board[i][j]==1 && count(board,i,j)>3)
                {
                    arr[i][j]=0;
                }
                else if(board[i][j]==0 && count(board,i,j)==3)
                {
                    arr[i][j]=1;
                }
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                board[i][j]=arr[i][j];
            }
        }
    }
}