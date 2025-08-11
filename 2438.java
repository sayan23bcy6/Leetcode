class Solution {
    public int[] productQueries(int n, int[][] queries) {
        long MOD = 1_000_000_007;
        ArrayList<Long> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add((long) (1 << i));
            }
        }
        long[] prefixProducts = new long[powers.size() + 1];
        prefixProducts[0] = 1;
        for (int i = 0; i < powers.size(); i++) {
            prefixProducts[i + 1] = (prefixProducts[i] * powers.get(i)) % MOD;
        }
        long[] prefixProductInverses = new long[powers.size() + 1];
        for (int i = 0; i < prefixProducts.length; i++) {
            prefixProductInverses[i] = power(prefixProducts[i], (int) (MOD - 2), MOD);
        }
        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long product = prefixProducts[right + 1];
            long divisorInverse = prefixProductInverses[left];
            answers[i] = (int) ((product * divisorInverse) % MOD);
        }
        return answers;
    }
    private long power(long base, int exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}