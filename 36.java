class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
            boolean freq[]=new boolean[9];
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                continue;
                else if(freq[board[i][j]-49])
                return false;
                else
                freq[board[i][j]-49]=true;
            }
        }
        for(int i=0;i<9;i++)
        {
            boolean freq[]=new boolean[9];
            for(int j=0;j<9;j++)
            {
                if(board[j][i]=='.')
                continue;
                else if(freq[board[j][i]-49])
                return false;
                else
                freq[board[j][i]-49]=true;
            }
        }
        for(int i=0;i<9;i+=3)
        {
            for(int j=0;j<9;j+=3)
            {boolean freq[]=new boolean[9];
                for(int k=j;k<j+3;k++)
                {
                if(board[i][k]=='.')
                continue;
                else if(freq[board[i][k]-49])
                return false;
                else
                freq[board[i][k]-49]=true;
                }
                for(int k=j;k<j+3;k++)
                {
                if(board[i+1][k]=='.')
                continue;
                else if(freq[board[i+1][k]-49])
                return false;
                else
                freq[board[i+1][k]-49]=true;
                }
                for(int k=j;k<j+3;k++)
                {
                if(board[i+2][k]=='.')
                continue;
                else if(freq[board[i+2][k]-49])
                return false;
                else
                freq[board[i+2][k]-49]=true;
                }
                
            }
        }
        return true;
    }
}