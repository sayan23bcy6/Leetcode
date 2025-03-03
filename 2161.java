class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int less = 0, equal = 0, greater = 0;

        for (int num : nums) {
            if (num < pivot) {
                less++;
            } else if (num == pivot) {
                equal++;
            } else {
                greater++;
            }
        }

        int lessIndex = 0, equalIndex = less, greaterIndex = less + equal;

        for (int num : nums) {
            if (num < pivot) {
                result[lessIndex++] = num;
            } else if (num == pivot) {
                result[equalIndex++] = num;
            } else {
                result[greaterIndex++] = num;
            }
        }

        return result;
    }
}
