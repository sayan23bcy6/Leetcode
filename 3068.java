class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long totalSum = 0;
        int countPositiveGain = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int num : nums) {
            int xorVal = num ^ k;
            if (xorVal > num) {
                countPositiveGain++;
                totalSum += xorVal;
                minDiff = Math.min(minDiff, xorVal - num);
            } else {
                totalSum += num;
                minDiff = Math.min(minDiff, num - xorVal);
            }
        }
        if (countPositiveGain % 2 != 0) {
            totalSum -= minDiff;
        }

        return totalSum;
    }
}
