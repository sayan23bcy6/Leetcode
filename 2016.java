class Solution {
    public int maximumDifference(int[] nums) {
        int minSoFar = nums[0];
        int best = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minSoFar) {
                best = Math.max(best, nums[i] - minSoFar);
            } else {
                minSoFar = nums[i];
            }
        }
        return best;
    }
}
