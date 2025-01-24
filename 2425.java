class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xorNums1 = 0;
        int xorNums2 = 0;
        for (int num : nums1) {
            xorNums1 ^= num;
        }

        for (int num : nums2) {
            xorNums2 ^= num;
        }

        return (nums1.length % 2) * xorNums2 ^ (nums2.length % 2) * xorNums1;
    }
}
