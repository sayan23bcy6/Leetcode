class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n+1];
        for (int i = 1; i <= n; i++) pre[i] = pre[i-1] + nums[i-1];
        long[] best = new long[k];
        for (int i = 0; i < k; i++) best[i] = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            int r = i % k;
            if (best[r] != Long.MAX_VALUE) max = Math.max(max, pre[i] - best[r]);
            best[r] = Math.min(best[r], pre[i]);
        }
        return max;
    }
}
