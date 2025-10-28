class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) continue;
            if (simulate(nums, i, -1)) total++;
            if (simulate(nums, i, 1)) total++;
        }
        return total;
    }

    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] copy = nums.clone();
        int curr = start;
        int d = dir;
        while (curr >= 0 && curr < n) {
            if (copy[curr] == 0) {
                curr += d;
            } else {
                copy[curr]--;
                d *= -1;
                curr += d;
            }
        }
        for (int num : copy) {
            if (num != 0) return false;
        }
        return true;
    }
}