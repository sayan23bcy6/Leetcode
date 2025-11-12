class Solution {
    public int minOperations(int[] nums) {
        int hcf = nums[0];
        int count = 0;
        int c = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) c++;
            if (i < n - 1) hcf = gcd(hcf, nums[i + 1]);
        }
        if (hcf != 1) return -1;
        if (c > 0) return n - c;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) return -1;
        return n + minLen - 2;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
