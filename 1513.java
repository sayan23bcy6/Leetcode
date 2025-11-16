class Solution {
    public int numSub(String s) {
        long mod = 1_000_000_007;
        long streak = 0;
        long sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') streak++;
            else streak = 0;
            sum = (sum + streak) % mod;
        }
        return (int) sum;
    }
}
