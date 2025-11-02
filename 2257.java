class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int sum = guards.length + walls.length;
        int[][] mat = new int[m][n];
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};

        for (int[] g : guards)
            mat[g[0]][g[1]] = 1;
        for (int[] w : walls)
            mat[w[0]][w[1]] = 1;

        for (int[] g : guards) {
            for (int i = 0; i < 4; i++) {
                int a = g[0], b = g[1];
                while (true) {
                    a += dx[i];
                    b += dy[i];
                    if (a < 0 || a >= m || b < 0 || b >= n || mat[a][b] == 1)
                        break;
                    if (mat[a][b] == 0) {
                        mat[a][b] = 2;   
                        sum++;
                    }
                }
            }
        }

        return m * n - sum;
    }
}
