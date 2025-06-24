class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        boolean[] marked = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);
                int end = Math.min(nums.length - 1, i + k);
                for (int j = start; j <= end; j++) {
                    marked[j] = true;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (marked[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
