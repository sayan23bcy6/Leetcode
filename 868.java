class Solution {
    public int binaryGap(int n) {
        int last = -1;
        int i = 0;
        int max = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                if (last != -1) {
                    max = Math.max(max, i - last);
                }
                last = i;
            }
            i++;
            n /= 2;
        }
        return max;
    }
}