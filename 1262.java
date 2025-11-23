class Solution {
    int[][] memo;
    final int NEG = Integer.MIN_VALUE / 4;

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        memo = new int[n + 1][3];
        for (int i = 0; i <= n; i++) Arrays.fill(memo[i], NEG);
        int[] res = dp(nums, 0);
        return Math.max(0, res[0]);
    }

    int[] dp(int[] nums, int i) {
        int n = nums.length;
        if (i == n) return new int[]{0, NEG, NEG};
        if (memo[i][0] != NEG || memo[i][1] != NEG || memo[i][2] != NEG) {
            return new int[]{memo[i][0], memo[i][1], memo[i][2]};
        }

        int[] next = dp(nums, i + 1);
        int[] cur = new int[3];
        cur[0] = next[0];
        cur[1] = next[1];
        cur[2] = next[2];

        int v = nums[i];
        int vr = v % 3;
        cur[vr] = Math.max(cur[vr], v);

        for (int r = 0; r < 3; r++) {
            if (next[r] != NEG) {
                int newR = (r + vr) % 3;
                cur[newR] = Math.max(cur[newR], next[r] + v);
            }
        }

        memo[i][0] = cur[0];
        memo[i][1] = cur[1];
        memo[i][2] = cur[2];
        return cur;
    }
}
