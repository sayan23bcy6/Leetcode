import java.util.HashMap;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] r = new int[n];
        int[] c = new int[m];
        HashMap<Integer, int[]> positions = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                positions.put(mat[i][j], new int[]{i, j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int[] position = positions.get(element);
            if (position != null) {
                int row = position[0];
                int col = position[1];
                r[row]++;
                c[col]++;
                if (r[row] == m || c[col] == n) {
                    return i;
                }
            }
        }
        return -1;
    }
}
