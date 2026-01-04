class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;

        for (int n : nums) {
            int count = 0;
            int sum = 0;

            for (int d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    int other = n / d;

                    if (d == other) {
                        count += 1;
                        sum += d;
                    } else {
                        count += 2;
                        sum += d + other;
                    }

                    if (count > 4) break;
                }
            }

            if (count == 4) total += sum;
        }

        return total;
    }
}
