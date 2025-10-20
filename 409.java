class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean hasOdd = false;
        for (int count : freq) {
            length += (count / 2) * 2;
            if ((count & 1)==1) hasOdd = true;
        }

        if (hasOdd) length += 1;
        return length;
    }
}
