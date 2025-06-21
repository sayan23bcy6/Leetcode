class Solution {
    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); ++i) cnt[word.charAt(i) - 'a']++;
        int[] vals = new int[26];
        int m = 0;
        for (int c : cnt) if (c > 0) vals[m++] = c;
        if (m == 0) return 0;
        java.util.Arrays.sort(vals, 0, m);
        int[] prefix = new int[m + 1];
        for (int i = 0; i < m; ++i) prefix[i + 1] = prefix[i] + vals[i];
        int ans = word.length();
        for (int i = 0; i < m; ++i) {
            int low = vals[i];
            int high = low + k;
            int del = prefix[i];
            for (int j = i; j < m; ++j) {
                if (vals[j] > high) del += vals[j] - high;
            }
            ans = Math.min(ans, del);
        }
        return ans;
    }
}
