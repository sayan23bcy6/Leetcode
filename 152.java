class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current_num = nums[i];
            int temp_max = Math.max(current_num, Math.max(current_num * max_so_far, current_num * min_so_far));
            min_so_far = Math.min(current_num, Math.min(current_num * max_so_far, current_num * min_so_far));

            max_so_far = temp_max;

            result = Math.max(result, max_so_far);
        }

        return result;
    }
}