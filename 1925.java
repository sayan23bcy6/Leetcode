class Solution {
    public int countTriples(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = n; j > i; j--) {
                double b = Math.sqrt(j * j - i * i);
                int bi = (int) b;
                if (b == Math.floor(b) && bi <= n && bi > i) {
                    count += 2;
                }
            }
        }
        return count;
    }
}
