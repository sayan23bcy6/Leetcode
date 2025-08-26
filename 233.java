class Solution {
    public int countDigitOne(int n) {
       if (n <= 0) return 0;
        String s = String.valueOf(n);
        int len = s.length();
        int highest = s.charAt(0) - '0';
        int pow = (int)Math.pow(10, len - 1);
        int remainder = n - highest * pow;

        if (highest == 1) {
            return countDigitOne(pow - 1) + countDigitOne(remainder) + remainder + 1;
        } else {
            return countDigitOne(pow - 1) * highest + countDigitOne(remainder) + pow;
        }
    }
}
