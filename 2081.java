public class Solution {

    private boolean isKPalindrome(long num, int k) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add((int)(num % k));
            num /= k;
        }
        for (int i = 0, j = digits.size() - 1; i < j; i++, j--) {
            if (!digits.get(i).equals(digits.get(j))) {
                return false;
            }
        }
        return true;
    }

    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;
        while (count < n) {
            int start = (int)Math.pow(10, (len - 1) / 2);
            int end = (int)Math.pow(10, (len + 1) / 2);
            for (int half = start; half < end; half++) {
                String s = Integer.toString(half);
                String rev = new StringBuilder(s).reverse().toString();
                String full = (len % 2 == 0) ? (s + rev) : (s + rev.substring(1));
                long num = Long.parseLong(full);
                if (isKPalindrome(num, k)) {
                    sum += num;
                    count++;
                    if (count == n) return sum;
                }
            }
            len++;
        }
        return sum;
    }
}
