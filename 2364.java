class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        long totalPairs = (long) n * (n - 1) / 2;
        long goodPairs = 0;

        for (int i = 0; i < n; i++) {
            int key = i - nums[i];
            goodPairs += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}