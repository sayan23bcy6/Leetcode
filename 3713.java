class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int num = s.charAt(j) - 'a';

                if (freq[num] == 0) {
                    distinct++;
                }

                freq[num]++;
                maxFreq = Math.max(maxFreq, freq[num]);

                int length = j - i + 1;

                if (maxFreq * distinct == length) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}
