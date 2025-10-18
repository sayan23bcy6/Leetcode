class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        long last = Long.MIN_VALUE;
        for (int num : nums) {
            long left = num - k;
            long right = num + k;
            long place = Math.max(left, last + 1);
            if (place <= right) {
                count++;
                last = place;
            }
        }
        return count;
    }
}