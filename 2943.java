class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxh = 1;
        int maxv = 1;

        int cur = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                cur++;
                maxh = Math.max(maxh, cur);
            } else {
                cur = 1;
            }
        }

        cur = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                cur++;
                maxv = Math.max(maxv, cur);
            } else {
                cur = 1;
            }
        }

        int side = Math.min(maxh + 1, maxv + 1);
        return side * side;
    }
}
