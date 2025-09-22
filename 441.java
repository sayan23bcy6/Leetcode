class Solution {
    public int arrangeCoins(int n) {
        long N = (long) n;
        long disc = 1 + 8 * N;
        long k = (long) ((Math.sqrt(disc) - 1) / 2);
        return (int) k;
    }
}
