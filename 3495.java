class Solution {
    public long minOperations(int[][] queries) {
        long totalOps = 0;
        for (int[] q : queries) {
            totalOps += solveQuery(q[0], q[1]);
        }
        return totalOps;
    }

    long solveQuery(int l, int r) {
        long steps = 0;
        int k = 0;
        while ((1L << (2 * k)) <= r) {
            long start = Math.max(l, 1L << (2 * k)); 
            long end   = Math.min(r, (1L << (2 * (k + 1))) - 1);
            if (start <= end) {
                long len = end - start + 1;
                steps += len * (k + 1);
            }
            k++;
        }
        return (steps + 1) / 2;
    }
}
