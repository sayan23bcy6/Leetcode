class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat=new int[n][n];
        for(int[] query:queries)
        {
            int r1=query[0];
            int r2=query[2];
            int c1=query[1];
            int c2=query[3];
            for (int r = r1; r <= r2; r++) {
                for(int c=c1;c<=c2;c++)
                {
                    mat[r][c]++;
                }
            }
        }
        return mat;
    }
}