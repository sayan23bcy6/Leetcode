class Solution {
    public double separateSquares(int[][] squares) {
        double total = 0;
        double low = Double.MAX_VALUE, high = Double.MIN_VALUE;

        for (int[] s : squares) {
            total += (double) s[2] * s[2];
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }

        double target = total / 2.0;

        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;
            double below = 0;

            for (int[] s : squares) {
                double y = s[1];
                double l = s[2];
                if (mid > y) {
                    below += Math.min(mid - y, l) * l;
                }
            }

            if (below < target) low = mid;
            else high = mid;
        }

        return low;
    }
}
