class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] freq = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            freq[nums1[i]]++;
        }

        for (int i = 0; i < nums2.length; i++) {
            if (freq[nums2[i]] > 0 && !list.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
